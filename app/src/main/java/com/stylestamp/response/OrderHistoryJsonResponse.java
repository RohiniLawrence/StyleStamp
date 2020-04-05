package com.stylestamp.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.stylestamp.model.Order;

import java.util.ArrayList;

public class OrderHistoryJsonResponse {
    @SerializedName("order")
    @Expose
    public ArrayList<Order> orders;
    public OrderHistoryJsonResponse(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
