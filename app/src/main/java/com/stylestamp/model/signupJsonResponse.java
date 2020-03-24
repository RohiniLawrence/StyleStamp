package com.stylestamp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class signupJsonResponse {
    @SerializedName("status")
    @Expose
    public int status;
    @SerializedName("signup_status")
    @Expose
    public String signup_status;
    @SerializedName("message")
    @Expose
    public String message;


    public signupJsonResponse(int status, String signup_status, String message, User user) {
        this.status = status;
        this.signup_status = signup_status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLogin_status() {
        return signup_status;
    }

    public void setLogin_status(String login_status) {
        this.signup_status = login_status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
