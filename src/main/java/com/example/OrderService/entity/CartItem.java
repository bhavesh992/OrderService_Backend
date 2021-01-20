package com.example.OrderService.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="cartitem")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartItem {


    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Id
    private String cartItemId;

    @ManyToOne
    @org.hibernate.annotations.Target(Cart.class)
    @JoinColumn(name="cart_id")
    private Cart cart;
    private String productId;
    private int colorId;
    private int sizeId;
    private String merchantId;
    private int quantity;
    private int price;

    public String getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId='" + cartItemId + '\'' +
                ", cart=" + cart +
                ", productId='" + productId + '\'' +
                ", colorId=" + colorId +
                ", sizeId=" + sizeId +
                ", merchantId='" + merchantId + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
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
}
