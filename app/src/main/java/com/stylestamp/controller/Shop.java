package com.stylestamp.controller;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.stylestamp.R;
import com.stylestamp.adapter.CategoryListAdapter;
import com.stylestamp.adapter.SubCategoryListAdapter;
import com.stylestamp.model.Category;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;

public class Shop extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    CategoryListAdapter categoryListAdapter;
    ViewFlipper viewFlipper;



    int images[] = {R.drawable.banner1, R.drawable.banner1_1, R.drawable.banner3};
    List<Category> categories = new ArrayList<>();
    List<Category> subCategories = new ArrayList<>();


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
        for(int image:images){
            flipperImages(image);
        }
        recyclerView =  (RecyclerView)  v.findViewById(R.id.recyclerView);
        initData();
        initRecyclerView();
        return v;

    }

    private void initRecyclerView() {

        categoryListAdapter = new CategoryListAdapter(this.getContext(), categories ,subCategories);
        recyclerView.setAdapter(categoryListAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);


    }

    private void initData() {
        categories = new ArrayList<>();
        categories.add(new Category(0,"Woman","sdasd",TRUE));
        categories.add(new Category(1,"Man","sdasd",TRUE));
        categories.add(new Category(2,"Kids","sdasd",TRUE));
        categories.add(new Category(3,"Home","sdasd",TRUE));
        subCategories = new ArrayList<>();
        subCategories.add(new Category(0,"Shirt","sdasd",TRUE));
        subCategories.add(new Category(1,"Bottoms","sdasd",TRUE));
        subCategories.add(new Category(2,"Accessories","sdasd",TRUE));
        subCategories.add(new Category(3,"Sale","sdasd",TRUE));
    }


       // recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));



    public void flipperImages(int image){
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);




    }
}
