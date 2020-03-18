package com.stylestamp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {

    @SerializedName("productId")
    @Expose
    private int productId;

    @SerializedName("stock")
    @Expose
    private int stock;

    @SerializedName("nbReviews")
    @Expose
    private int nbReviews;

    @SerializedName("reorderLevel")
    @Expose
    private int reorderLevel;

    @SerializedName("discountPercentage")
    @Expose
    private int discountPercentage;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("discription")
    @Expose
    private String description;

    @SerializedName("serialNumber")
    @Expose
    private String serialNumber;

    @SerializedName("brand")
    @Expose
    private String brand;

    @SerializedName("price")
    @Expose
    private double price;

    @SerializedName("isActive")
    @Expose
    private double isActive;

    @SerializedName("images")
    @Expose
    private List<String> images;

    @SerializedName("category")
    @Expose
    private Category category;

    //constructor

    public Product(int productId, int stock, int nbReviews, int reorderLevel, int discountPercentage, String name, String description, String serialNumber, String brand, double price, double isActive, Category category) {
        this.productId = productId;
        this.stock = stock;
        this.nbReviews = nbReviews;
        this.reorderLevel = reorderLevel;
        this.discountPercentage = discountPercentage;
        this.name = name;
        this.description = description;
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.price = price;
        this.isActive = isActive;
        //add after api ....       this.images = images;
        this.category = category;
    }

    //setters and getters


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getNbReviews() {
        return nbReviews;
    }

    public void setNbReviews(int nbReviews) {
        this.nbReviews = nbReviews;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getIsActive() {
        return isActive;
    }

    public void setIsActive(double isActive) {
        this.isActive = isActive;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
