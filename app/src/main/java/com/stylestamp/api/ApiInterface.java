package com.stylestamp.api;
import com.stylestamp.model.CategoryJsonResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {
//
//    @FormUrlEncoded
//    @POST("login")
//    Call<User> createUser(
//            @Header ("Authorization") String credentials,


    @GET("category/")
    Call<CategoryJsonResponse> getCategories();

}
