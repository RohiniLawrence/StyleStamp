package com.stylestamp.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.stylestamp.controller.CartFragment;

public class CartJasonResponse {
    @SerializedName("status")
    @Expose
    public int status;

    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("cart")
    @Expose
    public CartFragment cart;


    public CartJasonResponse(int status, String message, CartFragment cart) {
        this.status = status;
        this.message = message;
        this.cart = cart;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CartFragment getCart() {
        return cart;
    }

    public void setCart(CartFragment cart) {
        this.cart = cart;
    }
}
