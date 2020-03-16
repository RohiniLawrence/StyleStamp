package com.stylestamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.stylestamp.api.ApiClient;
import com.stylestamp.controller.Home;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent i = new Intent(this, Home.class);
//        startActivity(i);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        ApiClient client =  retrofit.create(ApiClient.class);

    }
}
