package com.example.OrderService.domain;

import com.example.OrderService.entity.CartItem;

public class CartItemData {

    private Product product;
    private Size size;
    private Color color;
    private MerchantStore merchantStore;
    private CartItem cartItem;

    public CartItemData(Product product, Size size, Color color, MerchantStore merchantStore, CartItem cartItem) {
        this.product = product;
        this.size = size;
        this.color = color;
        this.merchantStore = merchantStore;
        this.cartItem = cartItem;
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

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }
}
