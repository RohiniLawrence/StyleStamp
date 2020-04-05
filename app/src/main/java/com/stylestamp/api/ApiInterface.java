package com.stylestamp.api;
import com.stylestamp.controller.Cart;
import com.stylestamp.response.CartJasonResponse;
import com.stylestamp.response.CategoryJsonResponse;
import com.stylestamp.response.ProductJsonResponse;
import com.stylestamp.response.OrderHistoryJsonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("category/")
    Call<CategoryJsonResponse> getCategories(

            @Header("Authorization") String credential,
            @Header("X-API-KEY") String key
    );

    @GET("subcategory/")
    Call<CategoryJsonResponse> getSubCategories(

            @Header("Authorization") String credential,
            @Header("X-API-KEY") String key
    );
    @GET("getproductbycategoryid/{id}")
    Call<ProductJsonResponse> getProductByCategory(

            @Header("Authorization") String credential,
            @Header("X-API-KEY") String key,
            @Path("id") String id

    );

    //order history..

    @GET("orderHistory/")
    Call<OrderHistoryJsonResponse> getOrderHistory(

            @Header("Authorization") String credential,
            @Header("X-API-KEY") String key,
            @Path("id") String userId
    );
    //cart..

    @GET("cart/")
    Call<CartJasonResponse> getCart(
            @Header("Authorization") String credential,
            @Header("X-API-KEY") String key,
            @Query("userid") String userId
    );

    @GET("Productapi/")
    Call<ProductJsonResponse> getProducts(
            @Header("Authorization") String credential,
            @Header("X-API-KEY") String key
    );




}
