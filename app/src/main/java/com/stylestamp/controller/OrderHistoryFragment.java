package com.stylestamp.controller;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.stylestamp.MainActivity;
import com.stylestamp.R;
import com.stylestamp.adapter.OrderHistoryPagerAdapter;
import com.stylestamp.model.Order;

import java.util.ArrayList;
import java.util.List;


public class OrderHistoryFragment extends Fragment  {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private TabItem activeTab;
    private TabItem previousTab;
    private ViewPager viewPager;
    private OrderHistoryPagerAdapter pageAdapter;

    private List<Order> orders = new ArrayList<>();
    private List<Order> activeOrders = new ArrayList<>();
    private List<Order> previousOrders = new ArrayList<>();


    private String mParam1;
    private String mParam2;

    public OrderHistoryFragment() {

    }


    public static OrderHistoryFragment newInstance(String param1, String param2) {
        OrderHistoryFragment fragment = new OrderHistoryFragment();
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

        View view = inflater.inflate(R.layout.fragment_order_history, container, false);
        tabLayout = view.findViewById(R.id.orderHistoryTabbedLayout);

        /*activeTab = view.findViewById(R.id.active);
        previousTab = view.findViewById(R.id.previous);*/
        viewPager = view.findViewById(R.id.orderHistoryContainer);
        pageAdapter = new OrderHistoryPagerAdapter(getFragmentManager(), tabLayout.getTabCount(), activeOrders, previousOrders);
        viewPager.setAdapter(pageAdapter);

        /*viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
*/
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        return view;
    }

   /* private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private  List<String> fragmentList = new ArrayList<>();
        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public  void addFragment(Fragment fragment , String title ){
            fragments.add(fragment);
            fragmentList.add(title);

        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }


    }*/
}
