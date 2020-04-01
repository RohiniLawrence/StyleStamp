package com.stylestamp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CartInfo {

    @SerializedName("cartId")
    @Expose
    private int cartId;

    @SerializedName("cartItems")
    @Expose
    private List<CartItem> cartItemList ;

    @SerializedName("cartTotal")
    @Expose
    private double cartTotal;

    public CartInfo(int cartId, List<CartItem> cartItemList, double cartTotal) {
        this.cartId = cartId;
        this.cartItemList = cartItemList;
        this.cartTotal = cartTotal;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(int cartTotal) {
        this.cartTotal = cartTotal;
    }
}
