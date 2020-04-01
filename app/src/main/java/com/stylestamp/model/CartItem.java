package com.stylestamp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartItem {
    @SerializedName("cartItemId")
    @Expose
    private int cartItemId;

    @SerializedName("productID")
    @Expose
    private int productID;

    @SerializedName("cartItemSize")
    @Expose
    private String cartItemSize;

    @SerializedName("cartItemQuantity")
    @Expose
    private int cartItemQuantity;

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getCartItemSize() {
        return cartItemSize;
    }

    public void setCartItemSize(String cartItemSize) {
        this.cartItemSize = cartItemSize;
    }

    public int getCartItemQuantity() {
        return cartItemQuantity;
    }

    public void setCartItemQuantity(int cartItemQuantity) {
        this.cartItemQuantity = cartItemQuantity;
    }

    public CartItem(int cartItemId, int productID, String cartItemSize, int cartItemQuantity) {
        this.cartItemId = cartItemId;
        this.productID = productID;
        this.cartItemSize = cartItemSize;
        this.cartItemQuantity = cartItemQuantity;
    }
}
