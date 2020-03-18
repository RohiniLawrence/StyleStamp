package com.stylestamp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Category {

    public Category(int categoryId, String categoryName, String categoryDescription, Boolean isActive) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.isActive = isActive;
        expanded=false;

    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    private boolean expanded;

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
//                ", parentCategory=" + parentCategory +
                ", isActive=" + isActive +
                '}';
    }

    @SerializedName("categoryId")
    @Expose
    private int categoryId;

    @SerializedName("categoryName")
    @Expose
    private String categoryName;

    @SerializedName("categoryDescription")
    @Expose
    private String categoryDescription;

//    @SerializedName("parentCategory")
//    @Expose
//    private Category parentCategory;

    @SerializedName("isActive")
    @Expose
    private Boolean isActive;

//setters and getters


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

//    public Category getParentCategory() {
//        return parentCategory;
//    }
//
//    public void setParentCategory(Category parentCategory) {
//        this.parentCategory = parentCategory;
//    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
