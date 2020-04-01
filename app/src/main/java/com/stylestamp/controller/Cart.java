package com.stylestamp.controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.stylestamp.R;
import com.stylestamp.adapter.CartListAdapter;
import com.stylestamp.model.CartInfo;
import com.stylestamp.model.CartItem;
import com.stylestamp.model.Order;
import com.stylestamp.model.Product;

import java.util.ArrayList;
import java.util.List;


public class Cart extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private List<CartItem> cartItems = new ArrayList<>();
    private CartInfo cartInfo ;
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
        cartItems.add(new CartItem(0, 0, "S", 2));
        cartItems.add(new CartItem(0, 2, "S", 2));
        cartItems.add(new CartItem(0, 3, "S", 2));
        cartInfo = new CartInfo(0, cartItems, 97.26);

        Button btnCheckout;
        cartListAdapter = new CartListAdapter( getActivity(), cartItems);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_cart);
        recyclerView.setAdapter(cartListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

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
