package com.example.OrderService.domain;

import com.example.OrderService.entity.OrderItem;

public class OrderItemData {
    private Product product;
    private Size size;
    private Color color;
    private MerchantStore merchantStore;
    private OrderItem orderItem;

    public OrderItemData(Product product, Size size, Color color, MerchantStore merchantStore, OrderItem orderItem) {
        this.product = product;
        this.size = size;
        this.color = color;
        this.merchantStore = merchantStore;
        this.orderItem = orderItem;
    }


    public Product getProduct() {

        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public MerchantStore getMerchantStore() {
        return merchantStore;
    }

    public void setMerchantStore(MerchantStore merchantStore) {
        this.merchantStore = merchantStore;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }
}
