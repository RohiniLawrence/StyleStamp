package com.stylestamp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Product {

    @SerializedName("product_id")
    @Expose
    private String productId;

    @SerializedName("product_name")
    @Expose
    private String productName;

    @SerializedName("category_id")
    @Expose
    private String categoryId;

    @SerializedName("decription")
    @Expose
    private String description;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("stock")
    @Expose
    private String stock;

    @SerializedName("discount_percentage")
    @Expose
    private String discountPercentage;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("date_created")
    @Expose
    private String dateCreated;

    @SerializedName("images")
    @Expose
    private List<ProductImages> images;

    @SerializedName("specs")
    @Expose
    private ArrayList<ProductSpecs> specs;

    public Product(String productId, String productName, String categoryId, String description, String price, String stock, String discountPercentage, String status, String dateCreated, List<ProductImages> images, ArrayList<ProductSpecs> specs) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.discountPercentage = discountPercentage;
        this.status = status;
        this.dateCreated = dateCreated;
        this.images = images;
        this.specs = specs;
    }

    public ArrayList<ProductSpecs> getSpecs() {
        return specs;
    }

    public void setSpecs(ArrayList<ProductSpecs> specs) {
        this.specs = specs;
    }

    public List<ProductImages> getImages() {
        return images;
    }

    public void setImages(List<ProductImages> images) {
        this.images = images;
    }



    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}


