package com.stylestamp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CartProducts {

    @SerializedName("product_id")
    @Expose
    private int productId;

    @SerializedName("quantity")
    @Expose
    private int quantity;
    @SerializedName("size")
    @Expose
    private int size;
    @SerializedName("color")
    @Expose
    private int color;
    @SerializedName("product")
    @Expose
    private Product product;
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
