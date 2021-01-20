package com.example.OrderService.domain;

import java.io.Serializable;

public class RecommendedItem implements Serializable {
    private Inventory inventory;
    private double rating;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
