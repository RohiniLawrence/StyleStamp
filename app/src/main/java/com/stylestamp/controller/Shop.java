package com.stylestamp.controller;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.stylestamp.R;
import com.stylestamp.adapter.CategoryListAdapter;
import com.stylestamp.adapter.NewArrivalsAdapter;
import com.stylestamp.api.ApiClient;
import com.stylestamp.api.ApiInterface;
import com.stylestamp.model.Category;
import com.stylestamp.response.CategoryJsonResponse;
import com.stylestamp.model.Product;
import com.stylestamp.response.ProductJsonResponse;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Shop extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    Context context;

    RecyclerView recyclerView;
    CategoryListAdapter categoryListAdapter;
    ViewFlipper viewFlipper;
    SearchView searchView;
    Retrofit retrofit=ApiClient.getClient();

    ArrayList<Category> subCategories= new ArrayList<>();;
    ArrayList<Product> products= new ArrayList<>();;
    List<Category> categories = new ArrayList<>();

    int images[] = {R.drawable.banner1, R.drawable.banner1_1, R.drawable.banner3};



    public static Shop newInstance(String param1, String param2) {
        Shop fragment = new Shop();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Shop() {
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
        View v = inflater.inflate(R.layout.fragment_shop, container, false);
        viewFlipper = v.findViewById(R.id.viewPager);
        for (int image : images) {
            flipperImages(image);
        }
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        searchView = v.findViewById(R.id.searchView);


        ApiInterface apiInterface =retrofit.create(ApiInterface.class);
        String unm="admin";
        String pwd="1234";
        String base=unm+":"+pwd;
        String keyHeader="stylestamp@123";
        //basic authentication encryption to BASE64
        String authHeader="Basic "+ Base64.encodeToString(base.getBytes(),Base64.NO_WRAP);

        Call<CategoryJsonResponse> call= apiInterface.getCategories(authHeader,keyHeader);
        call.enqueue(new Callback<CategoryJsonResponse>() {
            @Override
            public void onResponse(Call<CategoryJsonResponse> call, Response<CategoryJsonResponse> response) {
                Log.e("shop-res",response.message());

                if(response.isSuccessful() && response.body().getCategories() != null){
                    if(!categories.isEmpty()){
                        categories.clear();
                    }
                    categories = response.body().getCategories();
                    categoryListAdapter = new CategoryListAdapter(getContext(), categories, subCategories);
                    recyclerView.setAdapter(categoryListAdapter);
                    categoryListAdapter.notifyDataSetChanged();
                    DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
                    recyclerView.addItemDecoration(dividerItemDecoration);
                }else{

                }
            }

            @Override
            public void onFailure(Call<CategoryJsonResponse> call, Throwable t) {
                Log.e("fail","-------fail");

                Log.e("fail",t.toString());
            }
        });

        subCategories.add(new Category(0,"sdfsdf","dasdas", "null"));
        subCategories.add(new Category(0,"sdfsdf","dasdas", "null"));
        subCategories.add(new Category(0,"sdfsdf","dasdas", "null"));






/*
        Call<ProductJsonResponse> callProducts = apiInterface.getProducts(keyHeader,authHeader);
        Log.i("Calling:","Products");

        callProducts.enqueue(new Callback<ProductJsonResponse>() {

            @Override
            public void onResponse(Call<ProductJsonResponse> call, Response<ProductJsonResponse> response) {
                if(response.body() != null) {

                    Log.i("products to string:",response.toString());
                    products = response.body().getProducts();
                }
            }

            @Override
            public void onFailure(Call<ProductJsonResponse> call, Throwable t) {
                Log.e("Products fail","-------fail");

            }
        });*/
       /* initData();*/
        initRecyclerView();


     /*   RecyclerView recyclerViewNewArrivals = (RecyclerView) v.findViewById(R.id.recyclerView_shop_newArrivals);
        final NewArrivalsAdapter newArrivalsAdapter = new NewArrivalsAdapter(getActivity(), products);
        recyclerViewNewArrivals.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewNewArrivals.setAdapter(newArrivalsAdapter);*/

        return v;

    }

    private void initRecyclerView() {



/*
        searchView.setMaxWidth(Integer.MAX_VALUE);


        // listening to search query text change
        searchView.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit (String query){
                // filter recycler view when query submitted
                categoryListAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange (String query){
                // filter recycler view when text is changed
                categoryListAdapter.getFilter().filter(query);
                return false;
            }
        });
    }

    private void initData() {






       /* products.add(new Product(0, 1, 0, 0, 0, "xyz", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));
        products.add(new Product(1, 1, 0, 0, 0, "abc", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));
        products.add(new Product(2, 1, 0, 0, 0, "asdas", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));
        products.add(new Product(3, 1, 0, 0, 0, "xaxa", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));
        products.add(new Product(0, 1, 0, 0, 0, "xyz", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));
        products.add(new Product(1, 1, 0, 0, 0, "abc", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));
        products.add(new Product(2, 1, 0, 0, 0, "asdas", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));
        products.add(new Product(3, 1, 0, 0, 0, "xaxa", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));
        products.add(new Product(0, 1, 0, 0, 0, "xyz", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));
        products.add(new Product(1, 1, 0, 0, 0, "abc", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));
        products.add(new Product(2, 1, 0, 0, 0, "asdas", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));
        products.add(new Product(3, 1, 0, 0, 0, "xaxa", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));
        products.add(new Product(0, 1, 0, 0, 0, "xyz", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));
        products.add(new Product(1, 1, 0, 0, 0, "abc", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));
        products.add(new Product(2, 1, 0, 0, 0, "asdas", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));
*/

       // recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));

    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
    }



}
