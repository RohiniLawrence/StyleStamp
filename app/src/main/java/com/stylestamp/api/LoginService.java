package com.stylestamp.api;

import com.stylestamp.model.jsonResponse;
import com.stylestamp.model.signupJsonResponse;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface LoginService {
    @FormUrlEncoded
    @POST("login/")
     Call<jsonResponse> basicLogin(
            @Header("X-API-KEY") String keyHeader,
            @Header("authorization") String authHeader,
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("signup/")
    Call<signupJsonResponse> basicSignup(
            @Header("X-API-KEY") String keyHeader,
            @Header("authorization") String authHeader,
            @Field("fname") String firstname,
            @Field("lname") String lastname,
            @Field("contact_no") String contact,
            @Field("email") String email,
            @Field("password") String password,
            @Field("gender") int gender,
               @Field("dob") Date dob
    );

}
