package com.stylestamp.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.stylestamp.model.Category;

import java.util.List;

public class SubCategoryResponse {
    @SerializedName("subcategories")
    @Expose
    public List<Category> subcategories;

    public List<Category> getSubcategories() {
        return subcategories;
    }
    public void setSubcategories(List<Category> subcategories) {
        this.subcategories = subcategories;
    }
}
