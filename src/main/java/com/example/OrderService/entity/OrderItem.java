package com.example.OrderService.entity;

import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;

@Entity
@Table(name="orderitem")
public class OrderItem {
    @Id
    private String orderItemId;


    @ManyToOne
    @org.hibernate.annotations.Target(Order.class)
    @JoinColumn(name="order_id")
    private Order order;

    private String productId;
    private int colorId;
    private int sizeId;

    public OrderItem(String orderItemId, Order order, String productId, int colorId, int sizeId, String merchantId, int quantity, int price, double rating) {
        this.orderItemId = orderItemId;
        this.order = order;
        this.productId = productId;
        this.colorId = colorId;
        this.sizeId = sizeId;
        this.merchantId = merchantId;
        this.quantity = quantity;
        this.price = price;
        this.rating = rating;
    }

    private String merchantId;
    private int quantity;
    private int price;
    private double rating;

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public OrderItem() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
