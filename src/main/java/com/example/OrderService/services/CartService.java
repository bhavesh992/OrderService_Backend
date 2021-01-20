package com.example.OrderService.services;

import com.example.OrderService.domain.CartItemData;
import com.example.OrderService.entity.Cart;
import com.example.OrderService.entity.CartItem;
import com.example.OrderService.exception.MaxOrderLimitReach;

import java.util.List;

public interface CartService {
    public CartItem addItemToCart(String cartId,CartItem cartItem) throws MaxOrderLimitReach;
    public void deleteItemFromCart(String cartItemId);
    public boolean checkIfItemIsExist(String cartId, String productId);
    public List<CartItemData> getAllItemsFromCart(String cartId);
    public void deleteCart(String cartId);
    public Cart createCart(Cart cart);
    public Cart getCartIdByUserId(String userId);
}
