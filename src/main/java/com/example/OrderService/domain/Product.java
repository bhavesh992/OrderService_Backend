package com.example.OrderService.domain;

import javax.persistence.*;
import java.io.Serializable;

public class Product implements Serializable {

    @Id
    private String productId;

    private String productName;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductRating() {
        return productRating;
    }

    public void setProductRating(int productRating) {
        this.productRating = productRating;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private int productRating;
    @ManyToOne
    @org.hibernate.annotations.Target(Category.class)
    @JoinColumn(name="category_id")
    private Category category;



}
