package com.stylestamp.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.stylestamp.R;
import com.stylestamp.api.ApiClient;
import com.stylestamp.api.LoginService;
import com.stylestamp.model.jsonResponse;

import java.text.SimpleDateFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignUp extends AppCompatActivity {

    EditText fname;
    EditText lname;
    EditText email;
    DatePicker dob;
    EditText address;
    EditText postalcode;
    EditText password;
    Button signupSub;

    String f_name,l_name,e_mail,Dob,Address,postal_code,pass;
    Retrofit retrofit= ApiClient.getClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        signupSub = findViewById(R.id.btnSignup);
        fname =  findViewById(R.id.editFirstname);
        lname = findViewById(R.id.editLastname);
        email = findViewById(R.id.editEmail);
        dob = findViewById(R.id.datePicker);
//        address=findViewById(R.id.textArea_information);
        postalcode=findViewById(R.id.editPostalCode);
        password=findViewById(R.id.editPostalCode);

        signupSub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                f_name=fname.getText().toString();
                l_name=lname.getText().toString();
                e_mail=email.getText().toString();

                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                Dob=sdf.format(dob);
//                Address=address.getText().toString();
                postal_code=postalcode.getText().toString();
                pass=password.getText().toString();



            }
        });
    }


    private void executeSignupUser(String fna,String password){
        LoginService loginService=retrofit.create(LoginService.class);
        String unm="admin";
        String pwd="1234";
        String base=unm+":"+pwd;
        String keyHeader="stylestamp@123";
        String authHeader="Basic "+ Base64.encodeToString(base.getBytes(),Base64.NO_WRAP);
        Call<jsonResponse> call=loginService.basicLogin(keyHeader,authHeader,email,password);
//                Call<User> call=loginService.basicLogin("jeelg46@gmail.com","12345678");
        Toast.makeText(getApplicationContext(),authHeader,Toast.LENGTH_LONG).show();
        call.enqueue(new Callback<jsonResponse>() {
            @Override
            public void onResponse(Call<jsonResponse> call, Response<jsonResponse> response) {
                Log.e("login-res",response.message());
                if(response.body() != null) {
                    int status = response.body().getStatus();
                    Log.e("status",String.valueOf(status));

                    Log.e("name",response.body().user.getFirstName()+" "+response.body().user.getLastName());
                    Log.e("email",response.body().user.getEmail());

                }


//                Toast.makeText(getApplicationContext(),response.body().toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<jsonResponse> call, Throwable t) {
//                Log.e("login-res",t.toString());
//                Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
