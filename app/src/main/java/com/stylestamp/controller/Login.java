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
import android.widget.EditText;
import android.widget.Toast;
import com.stylestamp.R;
import com.stylestamp.api.ApiClient;
import com.stylestamp.api.ApiInterface;
import com.stylestamp.api.LoginService;
import com.stylestamp.model.jsonResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login extends AppCompatActivity {
    EditText et_Email;
    EditText et_Pass;
    Button loginSub;
    String userEmail,userPassword;
    Retrofit retrofit=ApiClient.getClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        loginSub = findViewById(R.id.btn_login);
        et_Email =  findViewById(R.id.edtEmail);
        et_Pass = findViewById(R.id.edtPass);

        loginSub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                userEmail=et_Email.getText().toString();
                userPassword=et_Pass.getText().toString();

                if (userEmail.equals("") || userPassword.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Both Field", Toast.LENGTH_LONG).show();
                } else {
                    ConnectivityManager con = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo netw = null;
                    if (con != null) {
                        netw = con.getActiveNetworkInfo();
                    }
                    if (netw != null && netw.isConnected()) {
                        executeAuthenticateUser("jeelg46@gmail.com","12345678");
                    } else {
                        Toast.makeText(getApplicationContext(), "Internet Connection not available", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    private void executeAuthenticateUser(String email,String password){
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
//
//    private class LoginAsyncTask extends AsyncTask<Void, Void, Boolean> {
//        private final String email,password;
//
//        public LoginAsyncTask(String email, String password) {
//            this.email = email;
//            this.password = password;
//        }
//
//        @Override
//        protected Boolean doInBackground(Void... params) {
////            LoginService loginService=retrofit.create(LoginService.class);
////            String unm="admin";
////            String pwd="1234";
////            String base=unm+":"+pwd;
////            String keyHeader="stylestamp@123";
////            String authHeader="Basic "+ Base64.encodeToString(base.getBytes(),Base64.NO_WRAP);
////            Call<User>  call=LoginService.basicLogin(keyHeader,authHeader);
//////            call.execute();
////            try{
////                Response<User> response=call.execute();
////                if(response.isSuccessful()){
////                    return true;
////                }
////            }catch (IOException e){
////                e.printStackTrace();
////            }
//            return false;
//        }
//
//        @Override
//        protected void onPostExecute(final Boolean success) {
//            mAuthTask=null;
////            showProgress(false);
//            if(success){
//                Toast.makeText(getApplicationContext(),"successful login",Toast.LENGTH_LONG).show();
//            }
//            else{
//                Toast.makeText(getApplicationContext(),"unsuccessful login",Toast.LENGTH_LONG).show();
//            }
//        }
//
//        @Override
//        protected void onCancelled() {
//            super.onCancelled();
//        }
//    }



}




