package com.stylestamp.controller;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stylestamp.R;
import com.stylestamp.adapter.ProductDetailImagesListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProductDetail extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ProductDetail() {
    }


    ViewPager viewPager;
    ProductDetailImagesListAdapter proAdapter;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    int productImages[] = new int[]{R.drawable.banner3, R.drawable.banner1_1, R.drawable.banner1};


    public static ProductDetail newInstance(String param1, String param2) {
        ProductDetail fragment = new ProductDetail();
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


        View view = inflater.inflate(R.layout.fragment_product_detail, container, false);
        proAdapter = new ProductDetailImagesListAdapter(productImages, this.getActivity());
        viewPager = view.findViewById(R.id.proDetViewPager);
        viewPager.setAdapter(proAdapter);

        return view;
    }
}
