package com.stylestamp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cart {

    @SerializedName("cart_id")
    @Expose
    private String cartId;

    @SerializedName("user_id")
    @Expose
    private String userId;

    @SerializedName("cart_info")
    @Expose
    private List<CartInfo> cartInfo;

    public Cart(String cartId, String userId, List<CartInfo> cartInfo) {
        this.cartId = cartId;
        this.userId = userId;
        this.cartInfo = cartInfo;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<CartInfo> getCartInfo() {
        return cartInfo;
    }

    public void setCartInfo(List<CartInfo> cartInfo) {
        this.cartInfo = cartInfo;
    }
}
