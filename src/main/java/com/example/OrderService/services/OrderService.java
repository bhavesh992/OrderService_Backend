package com.example.OrderService.services;

import com.example.OrderService.domain.*;
import com.example.OrderService.entity.CartItem;
import com.example.OrderService.entity.Order;
import com.example.OrderService.entity.OrderItem;

import javax.mail.internet.AddressException;
import java.util.List;

public interface OrderService {
    Order saveOrder(String userId,List<CartItem> cartItems);
    List<OrderItemData> getOrderByUserId(String userId);
    List<OrderItemData> getOrderByMerchantId(String merchantId);
    void addRating(String orderItemId,double rating);
    double getRating(String orderItemId);
    int getTotalOrderPlacedByMerchantId(String merchantId);
    OrderItem getOrderItemByOrderItemId(String orderItemId);
    void sendMail(Order order) ;
    Order buyNow(OrderItem orderItem,String userId);
    List<OrderItemData> getOrderHistory(String userId);
    RatingData updateMerchantRating(String merchantId);
//    List<RecommendedItem> getRecommendation();
}
