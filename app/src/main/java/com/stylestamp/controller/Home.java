package com.stylestamp.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.stylestamp.R;

public class Home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    Shop shopFragment = new Shop();
    Profile profileFragment = new Profile();
    Cart cartFragment = new Cart();
    ProductFragment pd = new ProductFragment();

    private Toolbar toolbar;
    private static final String TAG = "HOME";
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        if (savedInstanceState == null) this. onNavigationItemSelected(bottomNavigationView.getMenu().getItem(0));
        bottomNavigationView.setSelectedItemId(R.id.nav_shop);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);



    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_shop:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, shopFragment).commit();
                return true;


            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
                return  true;

            case R.id.nav_cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, cartFragment).commit();
                return  true;

        }
        return false;
    }
}
