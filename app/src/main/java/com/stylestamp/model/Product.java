package com.stylestamp.model;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Product {

    @SerializedName("product_id")
    @Expose
    public String productId;
//
//    @SerializedName("product_name")
//    @Expose
//    private String productName;
//
//    @SerializedName("category_id")
//    @Expose
//    private String categoryId;
//
//    @SerializedName("decription")
//    @Expose
//    private String description;
//
//    @SerializedName("product_info_id")
//    @Expose
//    private String productspecsid;
//
//    @SerializedName("reorder_level")
//    @Expose
//    private String reorder_level;
//
//    @SerializedName("date_modified")
//    @Expose
//    private String date_modified;
//
//    @SerializedName("price")
//    @Expose
//    private String price;
//
//    @SerializedName("stock")
//    @Expose
//    private String stock;
//
//    @SerializedName("discount_percentage")
//    @Expose
//    private String discountPercentage;
//
//    @SerializedName("status")
//    @Expose
//    private String status;
//
//    @SerializedName("date_created")
//    @Expose
//    private String dateCreated;
//
//    @SerializedName("images")
//    @Expose
//    private List<ProductImages> images;
//
//    @SerializedName("specs")
//    @Expose
//    private ProductSpecs specs;
//
//    @SerializedName("created_by")
//    @Expose
//    private String created_by;
//
//    @SerializedName("modified_by")
//    @Expose
//    private String modified_by;


    public Product(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}


