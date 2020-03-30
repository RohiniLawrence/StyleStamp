package com.stylestamp.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stylestamp.R;

public class ForgetPassword extends AppCompatActivity {
    EditText et_Email;
    Button cont;
    String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        cont = findViewById(R.id.btnContinue);
        et_Email = findViewById(R.id.editEmail);

        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userEmail = et_Email.getText().toString();

                if (checkData()) {
                    setContentView(R.layout.activity_login);
                }
            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    private boolean checkData() {

        if (isEmail(et_Email) == false) {
            et_Email.setError("Enter valid email!");
        }
        return true;
    }
}