package com.stylestamp.controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.stylestamp.R;
import com.stylestamp.adapter.ProductListAdapter;
import com.stylestamp.api.ApiClient;
import com.stylestamp.api.ApiInterface;
import com.stylestamp.model.Category;
import com.stylestamp.model.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.Boolean.TRUE;


public class ProductFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    SearchView searchView;

    public ProductFragment() {
    }

    List<Product> products ;


    public static ProductFragment newInstance(String param1, String param2) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product, container, false);

        searchView = v.findViewById(R.id.searchView);


        products = new ArrayList<>();
        final RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.productRecyclerView);


        String unm = "admin";
        String pwd = "1234";
        String base = unm + ":" + pwd;
        String keyHeader = "stylestamp@123";
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);

        String categoryId = getArguments().getString("CategoryID");
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        if(categoryId=="all"){
            //___________GETTING ALL PRODUCTS_________________
            Call<List<Product>> call3 = apiInterface.getAllProducts(authHeader, keyHeader);
            call3.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call3, Response<List<Product>> response3) {
                    if (response3.isSuccessful() && response3.body() != null) {
                        if (!products.isEmpty()) {
                            products.clear();
                        }
                        products = response3.body();
                        final ProductListAdapter productListAdapter = new ProductListAdapter(getActivity(), products);
                        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                        recyclerView.setAdapter(productListAdapter);

                        // listening to search query text change
                        searchView.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
                            @Override
                            public boolean onQueryTextSubmit(String query) {
                                // filter recycler view when query submitted
                                productListAdapter.getFilter().filter(query);
                                return false;
                            }

                            @Override
                            public boolean onQueryTextChange(String query) {
                                // filter recycler view when text is changed
                                productListAdapter.getFilter().filter(query);
                                return false;
                            }
                        });
                    }
                     else {
                        Log.e("attaching--", "nothing-all pro");
                        Log.e("all pro--", response3.message());
                    }
                }
                @Override
                public void onFailure(Call<List<Product>> call3, Throwable t) {
                    Log.e("all pro fail--", t.toString());
                }
            });




            //___________GETTING PRODUCTS BY CATEGORY ID_________________


            Call<List<Product>> call = apiInterface.getProductByCategoryId(authHeader, keyHeader, categoryId);

            call.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        Log.e("product-res-body", response.body().toString());
                        products = response.body();
                        final ProductListAdapter productListAdapter = new ProductListAdapter(getActivity(), products);
                        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                        recyclerView.setAdapter(productListAdapter);

                        // listening to search query text change
                        searchView.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
                            @Override
                            public boolean onQueryTextSubmit(String query) {
                                // filter recycler view when query submitted
                                productListAdapter.getFilter().filter(query);
                                return false;
                            }

                            @Override
                            public boolean onQueryTextChange(String query) {
                                // filter recycler view when text is changed
                                productListAdapter.getFilter().filter(query);
                                return false;
                            }
                        });
                    } else {
                        Log.e("product-res-fail", response.message());
                    }
                }

                @Override
                public void onFailure(Call<List<Product>> call, Throwable t) {
                    Log.e("product-failure", t.toString());

                }
            });

        }
        searchView.setMaxWidth(Integer.MAX_VALUE);




        return v;
    }
}
