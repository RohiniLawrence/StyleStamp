package com.stylestamp.api;
import android.util.Base64;

import com.stylestamp.model.Cart;
import com.stylestamp.model.Category;
import com.stylestamp.model.Product;
import com.stylestamp.response.CategoryResponse;
import com.stylestamp.response.OrderHistoryJsonResponse;
import com.stylestamp.response.SubCategoryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {

    String unm = "admin";
    String pwd = "1234";
    String base = unm + ":" + pwd;
    final String keyHeader = "stylestamp@123";
    final String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);

    @GET("category/")
    Call<CategoryResponse> getCategories(
            @Header("Authorization") String credential,
            @Header("X-API-KEY") String key
    );

    @GET("subcategory/")
    Call<List<Category>> getSubCategories(
            @Header("Authorization") String credential,
            @Header("X-API-KEY") String key
    );

    @GET("subcategory/")
    Call<SubCategoryResponse> getSubCategoriesById(
            @Header("Authorization") String credential,
            @Header("X-API-KEY") String key,
            @Query("id") String id
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
    Call<Cart> getCart(
            @Header("Authorization") String credential,
            @Header("X-API-KEY") String key,
            @Query("userid") String userId
    );

    @GET("product/")
    Call<List<Product>> getProducts(
            @Header("Authorization") String credential,
            @Header("X-API-KEY") String key
    );

    @GET("getproductbyproductid/{id}")
    Call<Product> getProductById(
            @Header("Authorization") String credential,
            @Header("X-API-KEY") String key,
            @Path("id") String id
    );


}
