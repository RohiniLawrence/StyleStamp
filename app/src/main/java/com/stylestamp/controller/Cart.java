package com.stylestamp.controller;

import android.content.Intent;
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
import com.stylestamp.api.LoginService;
import com.stylestamp.model.CartInfo;
import com.stylestamp.response.CartJasonResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class Cart extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Retrofit retrofit = ApiClient.getClient();
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    private ArrayList<CartInfo> cartProducts = new ArrayList<>();
    private CartInfo cartInfo;
    private String mParam1;
    private String mParam2;
    CartListAdapter cartListAdapter;


    CheckOut checkOutFragment = new CheckOut();

    public Cart() {
        // Required empty public constructor
    }

    public static Cart newInstance(String param1, String param2) {
        Cart fragment = new Cart();
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
        View rootView = inflater.inflate(R.layout.fragment_cart, container, false);
        /*carts.add(new com.stylestamp.model.Cart(0, 0, "S", 2));
        carts.add(new com.stylestamp.model.Cart(0, 2, "S", 2));
        carts.add(new com.stylestamp.model.Cart(0, 3, "S", 2));
        cartInfo = new CartInfo(0, carts, 97.26);*/
        Cart cart = new Cart();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_cart);

        sp = getActivity().getSharedPreferences("mp", 0);
        editor = sp.edit();
        String uid = sp.getString("uid", null);


        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        String unm = "admin";
        String pwd = "1234";
        String base = unm + ":" + pwd;
        String keyHeader = "stylestamp@123";
        //basic authentication encryption to BASE64
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);
        //call login service

        Call<CartJasonResponse> call = apiInterface.getCart(keyHeader, authHeader, uid);
        call.enqueue(new Callback<CartJasonResponse>() {
            @Override
            public void onResponse(Call<CartJasonResponse> call, Response<CartJasonResponse> response) {
                //checks responce is not empty
                if (response.body() != null) {

                    CartJasonResponse cartJasonResponse = response.body();
                    cartProducts 
                    cartListAdapter = new CartListAdapter(getActivity(), );

                    recyclerView.setAdapter(cartListAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

                }
            }

            @Override
            public void onFailure(Call<CartJasonResponse> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(), "problem while retrieving data from server ", Toast.LENGTH_SHORT).show();
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
}
