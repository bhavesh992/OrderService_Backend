package com.example.OrderService.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart  {
    @Id
    private String cartId;
    private String userId;

    public Cart(String cartId, String userId) {
        this.cartId = cartId;
        this.userId = userId;
    }

    public Cart() {
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
