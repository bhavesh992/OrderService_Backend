package com.example.OrderService.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
    @Id
    private String orderId;
    private String userId;

    public Order() {
    }

    public Order(String orderId, String userId) {
        this.orderId = orderId;
        this.userId = userId;

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
