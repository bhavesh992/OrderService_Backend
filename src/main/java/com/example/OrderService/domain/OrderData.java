package com.example.OrderService.domain;

import com.example.OrderService.entity.CartItem;

import java.util.List;

public class OrderData {
    private String userId;
    List<CartItem> cartItemList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }
}
