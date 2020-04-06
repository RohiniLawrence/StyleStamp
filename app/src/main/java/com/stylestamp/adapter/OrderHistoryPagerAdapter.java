package com.stylestamp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.stylestamp.response.OrderHistoryJsonResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderHistoryPagerAdapter {/*extends FragmentPagerAdapter{

    private int numOfTabs;
    Context context;
    //List<Order> activeOrders = new ArrayList<>();
   // List<Order> previousOrders = new ArrayList<>();

    public OrderHistoryPagerAdapter(FragmentManager fm, int numOfTabs ,List<Order> activeOrders, List<Order> previousOrders ) {
        super(fm);
        this.numOfTabs = numOfTabs;
        this.activeOrders = activeOrders;
        this.previousOrders = previousOrders;
    }

    @Override
    public Fragment getItem(final int position) {




    @Override
    public int getCount() {
        return numOfTabs;
    }*/
}
