package com.stylestamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;


import com.stylestamp.controller.Home;
import com.stylestamp.controller.Shop;
import com.stylestamp.controller.Splash;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(getApplicationContext(), Splash.class);
        startActivity(i);

//
//
//        ApiClient client =  retrofit.create(ApiClient.class);

    }
}
