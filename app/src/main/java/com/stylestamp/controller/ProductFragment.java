package com.stylestamp.controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.stylestamp.R;
import com.stylestamp.adapter.ProductListAdapter;
import com.stylestamp.model.Category;
import com.stylestamp.model.Product;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;


public class ProductFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    SearchView searchView;

    public ProductFragment() {
    }

    ArrayList<Product> products;


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

        //remove after api----------------
       List<Category> categories = new ArrayList<>();
        categories.add(new Category(0,"Men","dasdas", "null"));
        categories.add(new Category(0,"Women","dasdas", "null"));
        categories.add(new Category(0,"Kids","dasdas", "null"));
        categories.add(new Category(0,"Home","dasdas", "null"));


        //---------------------

        products = new ArrayList<>();
        String categoryId = getArguments().getString("CategoryID");
        //here we have the category ID so when the user clicks on a category they see products from that category.....i just need to fetch all the products from that category


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
        products.add(new Product(1, 1, 0, 0, 0, "abc", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));
        products.add(new Product(2, 1, 0, 0, 0, "asdas", "oh what a great clothing piece this is......sdsasdasdasda....asdasd", "fsdf132", "dasads", 49.99, 1,  categories.get(0)));

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.productRecyclerView);
        final ProductListAdapter productListAdapter = new ProductListAdapter(getActivity(), products);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(productListAdapter);

        searchView.setMaxWidth(Integer.MAX_VALUE);


        // listening to search query text change
        searchView.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit (String query){
                // filter recycler view when query submitted
                productListAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange (String query){
                // filter recycler view when text is changed
                productListAdapter.getFilter().filter(query);
                return false;
            }
        });

        return v;
    }
}
