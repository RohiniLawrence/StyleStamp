package com.stylestamp.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartJasonResponse {
    @SerializedName("status")
    @Expose
    public int status;

    @SerializedName("message")
    @Expose
    public String message;
}
