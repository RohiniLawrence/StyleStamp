package com.stylestamp.adapter;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.stylestamp.controller.ActiveOrderFragment;
import com.stylestamp.controller.PreviousOrderFragment;
import com.stylestamp.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryPagerAdapter extends FragmentPagerAdapter{

    private int numOfTabs;

    List<Order> orders = new ArrayList<>();
    List<Order> activeOrders = new ArrayList<>();
    List<Order> previousOrders = new ArrayList<>();



    public OrderHistoryPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }


    @Override
    public Fragment getItem(int position) {


        orders.add(new Order(0, "active"));
        orders.add(new Order(2, "previous"));
        orders.add(new Order(3, "active"));
        orders.add(new Order(4, "previous"));
        orders.add(new Order(5, "active"));
        activeOrders.clear();
        previousOrders.clear();
        for (Order order : orders) {

            Log.e("Order",order.getOrderStatus());
            if(order.getOrderStatus().equals("active")){

                activeOrders.add(order);
            }
            else{
                previousOrders.add(order);

            }
        }

        switch (position) {
            case 0:
                return new ActiveOrderFragment(activeOrders);
            case 1:
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
