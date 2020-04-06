package com.stylestamp.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductSpecs {
    @SerializedName("color")
    @Expose
    private List<String> color;

    @SerializedName("size")
    @Expose
    private List<String> sizes;
    @SerializedName("composition")
    @Expose
    private String composition;

    public List<String> getColor() {
        return color;
    }

    public void setColor(List<String> color) {
        this.color = color;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }
}