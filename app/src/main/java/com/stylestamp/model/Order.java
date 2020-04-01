package com.stylestamp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Order {
    public Order(int orderId, String orderStatus) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }

    @SerializedName("order_id")
    @Expose
    private int orderId;

    @SerializedName("user_id")
    @Expose
    private int uesrId;


    @SerializedName("orderDate")
    @Expose
    private Date orderDate;

    @SerializedName("shipDate")
    @Expose
    private Date shipDate;

    @SerializedName("order_status")
    @Expose
    private String orderStatus;

    @SerializedName("shipped_status")
    @Expose
    private String shipStatus;

    @SerializedName("payment_type")
    @Expose
    private String paymentType;

    @SerializedName("shippingAddress")
    @Expose
    private Address shippingAddress;

    @SerializedName("billingAddress")
    @Expose
    private Address billingAddress;

    @SerializedName("orderInfo")
    @Expose
    private OrderInfo orderInfo;

    @SerializedName("promotion_id")
    @Expose
    private Integer promotionId;


    //setters and getters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUesrId() {
        return uesrId;
    }

    public void setUesrId(int uesrId) {
        this.uesrId = uesrId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(String shipStatus) {
        this.shipStatus = shipStatus;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }
}
