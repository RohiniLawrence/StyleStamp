package com.stylestamp.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.*;
import com.stylestamp.R;
import com.stylestamp.api.ApiClient;
import com.stylestamp.api.ApiInterface;
import com.stylestamp.model.User;
import com.stylestamp.utils.CommonMethods;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

 ApiInterface apiInterface;
    EditText et_Email;
    EditText et_Pass;
    Button loginSub;
    String userEmail,userPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        loginSub = (Button) findViewById(R.id.btn_login);
        et_Email = (EditText) findViewById(R.id.edtEmail);
        et_Pass = (EditText) findViewById(R.id.edtPass);

        loginSub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                userEmail=et_Email.getText().toString();
                userPassword=et_Pass.getText().toString();
                if (checkValidation()) {
                    if (CommonMethods.isNetworkAvailable(Login.this))
                        loginRetrofit2Api(userEmail,userPassword);
                    else
                        CommonMethods.showAlert("Internet Connectivity Failure", Login.this);
                }
            }
        });
    }
    private void loginRetrofit2Api(String userId, String password) {
        final User user = new User(userId, password);
        Call<User> call1 = apiInterface.createUser(user);
        call1.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User User = response.body();

                Log.e("Login-Log", "User 1 --> " + User);
                if (User != null) {
                    Log.e("Login-Log", "getUserId          -->  " + User.getUserId());
                    Log.e("Login-Log", "getFirstName       -->  " + User.getFirstName());
                    Log.e("Login-Log", "getLastName        -->  " + User.getLastName());
//                    Log.e("Login-Log", "getProfilePicture  -->  " + User.getProfilePicture());

                    String responseCode = User.getResponseCode();
                    Log.e("Login-Log", "getResponseCode  -->  " + User.getResponseCode());
//                    Log.e("Login-Log", "getResponseMessage  -->  " + User.getResponseMessage());
                    if (responseCode != null && responseCode.equals("404")) {
                        Toast.makeText(Login.this, "Invalid Login Details \n Please try again", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Login.this, "Welcome " + User.getFirstName(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "onFailure called ", Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });
    }

    public boolean checkValidation() {
        userEmail = et_Email.getText().toString();
        userPassword = et_Pass.getText().toString();

        Log.e("Login-Log", "userId is -> " + userEmail);
        Log.e("Login-Log", "password is -> " + userPassword);

        if (et_Email.getText().toString().trim().equals("")) {
            CommonMethods.showAlert("UserId Cannot be left blank", Login.this);
            return false;
        } else if (et_Pass.getText().toString().trim().equals("")) {
            CommonMethods.showAlert("password Cannot be left blank", Login.this);
            return false;
        }
        return true;
    }
}




