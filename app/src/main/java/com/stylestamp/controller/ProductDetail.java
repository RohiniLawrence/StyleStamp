package com.stylestamp.controller;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stylestamp.R;
import com.stylestamp.adapter.NewArrivalsAdapter;
import com.stylestamp.adapter.ProductDetailImagesListAdapter;
import com.stylestamp.adapter.RelatedProductsAdapter;
import com.stylestamp.model.Category;
import com.stylestamp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDetail extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private String productID;

    public ProductDetail(String productID) {
        this.productID = productID;
    }




    ViewPager viewPager;
    ProductDetailImagesListAdapter proAdapter;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    int productImages[] = new int[]{R.drawable.banner3, R.drawable.banner1_1, R.drawable.banner1};

    public ProductDetail() {

    }


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
        ArrayList<Category> categories = new ArrayList<>();
     /*   categories.add(new Category(0,"Men","dasdas", "null"));
        categories.add(new Category(0,"Women","dasdas", "null"));
        categories.add(new Category(0,"Kids","dasdas", "null"));
        categories.add(new Category(0,"Home","dasdas", "null"));*/
        ArrayList<Product> products = new ArrayList<>();
/*
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
        products.add(new Product(3, 1, 0, 0, 0, "xaxa", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));
        products.add(new Product(0, 1, 0, 0, 0, "xyz", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));

*/






        RecyclerView recyclerViewRelatedProduct = (RecyclerView) view.findViewById(R.id.recyclerView_shop_relatedProducts);
        final RelatedProductsAdapter relatedProductsAdapter = new RelatedProductsAdapter(getActivity(), products);
        recyclerViewRelatedProduct.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewRelatedProduct.setAdapter(relatedProductsAdapter);

        return view;
    }
}
