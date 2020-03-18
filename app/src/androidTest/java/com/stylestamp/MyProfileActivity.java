package com.example.stylestamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyProfileActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnMyAccount,btnOrderHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        initialize();

    }

    private void initialize() {
        btnMyAccount = findViewById(R.id.btnMyAccount);
        btnOrderHistory = findViewById(R.id.btnorderhistory);
        btnMyAccount.setOnClickListener(this);
        btnOrderHistory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnMyAccount:
                Intent i = new Intent(this,MyAccountActivity.class);
                startActivity(i);
                break;
            case R.id.btnorderhistory:

        }
    }
}
