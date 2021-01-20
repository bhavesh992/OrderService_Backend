package com.example.OrderService.domain;

public class RatingData {
    private String merchantId;
    private double rating;

    public RatingData(String merchantId, double rating) {
        this.merchantId = merchantId;
        this.rating = rating;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
