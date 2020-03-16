package com.stylestamp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Address {

    @SerializedName("addressId")
    @Expose
    private int addressId;

    @SerializedName("street")
    @Expose
    private int street;

    @SerializedName("civicNo")
    @Expose
    private int civicNo;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("postalCode")
    @Expose
    private String postalCode;

    @SerializedName("apartmentNumber")
    @Expose
    private int apartmentNumber;

    @SerializedName("addressStatus")
    @Expose
    private String status;

    @SerializedName("addressType")
    @Expose
    private String addressType;

    @SerializedName("createdDate")
    @Expose
    private Date createdDate;

    @SerializedName("createdBy")
    @Expose
    private int createdBy;

    @SerializedName("modifiedDate")
    @Expose
    private Date modifiedDate;

    @SerializedName("modifiedBy")
    @Expose
    private int modifiedBy;

    //setters and getters

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getStreet() {
        return street;
    }

    public void setStreet(int street) {
        this.street = street;
    }

    public int getCivicNo() {
        return civicNo;
    }

    public void setCivicNo(int civicNo) {
        this.civicNo = civicNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
