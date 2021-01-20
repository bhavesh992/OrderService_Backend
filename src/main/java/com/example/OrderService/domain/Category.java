package com.example.OrderService.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Category {

    @Id
    private String categoryId;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    private String categoryName;
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
