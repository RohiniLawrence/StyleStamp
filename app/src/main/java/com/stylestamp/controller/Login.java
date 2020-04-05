package com.stylestamp.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.stylestamp.MainActivity;
import com.stylestamp.R;
import com.stylestamp.api.ApiClient;
import com.stylestamp.api.ApiInterface;
import com.stylestamp.api.LoginService;
import com.stylestamp.response.JsonResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login extends AppCompatActivity {
    EditText et_Email;
    EditText et_Pass;
    Button loginSub,btnSignup;
    String userEmail,userPassword;
    Retrofit retrofit=ApiClient.getClient();
    TextView skip,forgetpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSignup=findViewById(R.id.btnSignup);
        loginSub = findViewById(R.id.btn_login);
        et_Email =  findViewById(R.id.edtEmail);
        et_Pass = findViewById(R.id.edtPass);
        skip=findViewById(R.id.txtSkip);
        forgetpassword=findViewById(R.id.txtForgotPassword);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Login.this, Home.class);
                startActivity(in);
            }
        });
        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Login.this, ForgetPassword.class);
                startActivity(in);
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Login.this, SignUp.class);
                startActivity(in);
            }
        });
        loginSub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                userEmail=et_Email.getText().toString();
                userPassword=et_Pass.getText().toString();
                ConnectivityManager con = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo netw = null;
                if (con != null) {
                    netw = con.getActiveNetworkInfo();
                }
                if (netw != null && netw.isConnected()) {
                    if(checkdata(userEmail,userPassword)) {
                        //calling service
                        executeAuthenticateUser(userEmail, userPassword);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Internet Connection not available", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    // validate email id and password
    private boolean checkdata(String userEmail, String userPassword) {
        if(isValidEmail(userEmail)){
            return true;
        }else{
            Toast.makeText(getApplicationContext(), "email id is mandatory and must be in valid format", Toast.LENGTH_LONG).show();
        }
        if(isValidPassword(userPassword)){
            return true;
        }else{
            Toast.makeText(getApplicationContext(), "password is mandatory and must be atleast 8 character long", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    private void executeAuthenticateUser(String email,String password){//send request to base_url with necessary header authentication keys and parameters
        LoginService loginService=retrofit.create(LoginService.class);
        String unm="admin";
        String pwd="1234";
        String base=unm+":"+pwd;
        String keyHeader="stylestamp@123";
        //basic authentication encryption to BASE64
        String authHeader="Basic "+ Base64.encodeToString(base.getBytes(),Base64.NO_WRAP);
        //call login service
        Call<JsonResponse> call=loginService.basicLogin(keyHeader,authHeader,email,password);
        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                //checks responce is not empty
                if(response.body() != null) {
                    int status = response.body().getStatus();
                    //check the login status code
                    if(status==1){
                        JsonResponse jsonResponse=response.body();
                        Log.e("status",String.valueOf(status));
                        Log.e("name",response.body().user.getFirstName()+" "+response.body().user.getLastName());
                        Log.e("email",response.body().user.getEmail());
                        SharedPreferences pref = getApplicationContext().getSharedPreferences("mp", 0); // 0 - for private mode
                        Intent intent=new Intent(Login.this,Home.class);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("uid", jsonResponse.getUser().getUserId());
                        editor.putString("first name",jsonResponse.getUser().getFirstName());
                        editor.putString("last name",jsonResponse.getUser().getLastName());
                        editor.putString("email",jsonResponse.getUser().getEmail());
                        editor.putString("password",jsonResponse.getUser().getPassword());
                        editor.commit();
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"login success",Toast.LENGTH_SHORT).show();
                    }
                    else if(status==0){
                        Log.e("status",String.valueOf(status));
                        Toast.makeText(getApplicationContext(),"invalid credentials! try again",Toast.LENGTH_SHORT).show();
                    }

                }
            }
            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"problem while retrieving data from server ",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
    public static boolean isValidPassword(CharSequence target) {
        return (!TextUtils.isEmpty(target) && target.length()>=8);
    }
}




