package com.stylestamp.controller;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.stylestamp.R;
import com.stylestamp.adapter.CartListAdapter;
import com.stylestamp.api.ApiClient;
import com.stylestamp.api.ApiInterface;
import com.stylestamp.model.Cart;
import com.stylestamp.model.CartProducts;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class CartFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    private ArrayList<CartProducts> cartProducts = new ArrayList<>();
    private String mParam1;
    private String mParam2;
    CartListAdapter cartListAdapter;


    CheckOut checkOutFragment = new CheckOut();

    public CartFragment() {
        // Required empty public constructor
    }

    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
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
        final View rootView = inflater.inflate(R.layout.fragment_cart, container, false);
        /*carts.add(new com.stylestamp.model.Cart(0, 0, "S", 2));
        carts.add(new com.stylestamp.model.Cart(0, 2, "S", 2));
        carts.add(new com.stylestamp.model.Cart(0, 3, "S", 2));
        cartInfo = new CartInfo(0, carts, 97.26);*/

        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_cart);
        sp = getActivity().getSharedPreferences("mp", 0);
        editor = sp.edit();
        String uid = sp.getString("uid", null);
        Log.e("uid", uid);


        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        String unm = "admin";
        String pwd = "1234";
        String base = unm + ":" + pwd;
        String keyHeader = "stylestamp@123";
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);
        Call<Cart> call;
        call = apiInterface.getCart(authHeader, keyHeader, "1");
        call.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {
                if(response.isSuccessful() && response.body() != null ){
                    if(!cartProducts.isEmpty()){
                        cartProducts.clear();
                    }

                    Log.e("attaching", "cartListAdapter");
                    cartProducts = response.body().getCartProducts();
                    cartListAdapter = new CartListAdapter(getActivity(), cartProducts);
                    recyclerView.setAdapter(cartListAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


                }
                else{

                    Log.e("attaching", "nothing-cart");
                    Log.e("res-body", response.message() );
                    Toast.makeText(getActivity(), "No results", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Cart> call, Throwable t) {
                Log.e("problem: ", t.toString());
            }
        });





        Button btnCheckout;
        btnCheckout = rootView.findViewById(R.id.btnCheckout);
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, checkOutFragment).commit();
            }
        });

        return rootView;
    }

    public void LoadJson(){


    }
}
