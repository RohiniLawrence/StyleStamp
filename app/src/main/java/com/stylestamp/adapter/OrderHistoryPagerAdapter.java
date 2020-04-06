package com.stylestamp.adapter;

import android.util.Base64;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.stylestamp.api.ApiClient;
import com.stylestamp.api.ApiInterface;
import com.stylestamp.controller.ActiveOrderFragment;
import com.stylestamp.controller.PreviousOrderFragment;
import com.stylestamp.model.Order;
import com.stylestamp.response.CategoryResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderHistoryPagerAdapter extends FragmentPagerAdapter{

    private int numOfTabs;
    List<Order> activeOrders = new ArrayList<>();
    List<Order> orders = new ArrayList<>();
    List<Order> previousOrders = new ArrayList<>();

    public OrderHistoryPagerAdapter(FragmentManager fm, int numOfTabs ,List<Order> activeOrders, List<Order> previousOrders ) {
        super(fm);
        this.numOfTabs = numOfTabs;
        this.activeOrders = activeOrders;
        this.previousOrders = previousOrders;
    }

    @Override
    public Fragment getItem(int position) {
/*
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        String unm="admin";
        String pwd="1234";
        String base=unm+":"+pwd;
        String keyHeader="stylestamp@123";
        String authHeader="Basic "+ Base64.encodeToString(base.getBytes(),Base64.NO_WRAP);
        final Call<CategoryResponse> call= apiInterface.getCategories(authHeader,keyHeader);
        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                Log.e("shop-res",response.message());

                if(response.isSuccessful() && response.body().getCategories() != null){
                    if(!orders.isEmpty()){
                        orders.clear();
                    }
                    orders = response.body().getCategories();

                }else{

                }

            }
            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {

                Log.e("fail",t.toString());
            }
        });*/


        activeOrders.clear();
        previousOrders.clear();
        for (Order order : orders) {
            if (order.getOrderStatus().equals("active")) {
                activeOrders.add(order);
            } else {
                previousOrders.add(order);
            }
        }
        switch (position) {
            case 0:
                Log.e("Fragment Called","Active");
                return new ActiveOrderFragment(activeOrders);
            case 1:
                Log.e("Fragment Called","Previous");
                return new PreviousOrderFragment(previousOrders);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
