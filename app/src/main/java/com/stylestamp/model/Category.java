package com.stylestamp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Category {



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

                '}';
    }

    @SerializedName("category_id")
    @Expose
    private int categoryId;

    @SerializedName("category_name")
    @Expose
    private String categoryName;

    @SerializedName("description")
    @Expose
    private String categoryDescription;

    @SerializedName("parent_category")
    @Expose
   private String parentCategory;

 /*   @SerializedName("status")
    @Expose
    private Boolean isActive;*/

    public Category( int categoryId, String categoryName, String categoryDescription, String parentCategory) {
        this.expanded = false;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.parentCategory = parentCategory;

    }

    //setters and getters


    public String getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(String parentCategory) {
        this.parentCategory = parentCategory;
    }

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


}
