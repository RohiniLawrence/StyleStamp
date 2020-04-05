package com.stylestamp.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.stylestamp.MainActivity;
import com.stylestamp.R;

public class Splash extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    int s=0,n=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sp = getSharedPreferences("mp", 0);
        editor = sp.edit();
//
//        SharedPreferences sp = getSharedPreferences("mp", 0);
        String email=sp.getString("email",null);
        if(email==null){
            n=1;
        }
        Thread d=new Thread()
        {
            @Override
            public void run() {
                try
                {
                    Thread.sleep(2000);
                }
                catch(Exception e){

                }
                finally {

                    if(n==1)
                    {
                        Intent in = new Intent(Splash.this, Login.class);
                        startActivity(in);
                    }
                    else
                    {
                        Intent in = new Intent(Splash.this, Home.class);
                        startActivity(in);
                    }
                }

            }
        };
        d.start();
    }
}