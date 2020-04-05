package com.stylestamp.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.stylestamp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductJsonResponse {
    @SerializedName("product")
    @Expose
    public List<Product> products;
    public ProductJsonResponse(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}