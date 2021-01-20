package com.example.OrderService.services.impl;

import com.example.OrderService.domain.*;
import com.example.OrderService.entity.CartItem;
import com.example.OrderService.entity.MailSenderThread;
import com.example.OrderService.entity.Order;
import com.example.OrderService.entity.OrderItem;
import com.example.OrderService.feignclient.MerchantClient;
import com.example.OrderService.feignclient.ProductClient;
import com.example.OrderService.repository.OrderItemRepository;
import com.example.OrderService.repository.OrderRepository;
import com.example.OrderService.services.CartService;
import com.example.OrderService.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class OrderServiceImpl  implements OrderService {
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductClient productClient;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private  MerchantClient merchantClient;
    @Override
    public Order saveOrder(String userId, List<CartItem> cartItems) {
        System.out.println("called with userId="+userId);
        Order order=new Order(UUID.randomUUID().toString().substring(0, 32),userId);
        orderRepository.save(order);

        List<OrderItem> orderItems=new ArrayList<>(cartItems.size());

        for(CartItem cartItem:cartItems)
        {
            productClient.reduceQuantityByInventoryPk(cartItem.getProductId(), cartItem.getSizeId(), cartItem.getColorId(), cartItem.getMerchantId());
            if(cartItem.getQuantity()>0) {
                System.out.println("called="+cartItem.getQuantity());

                orderItems.add(new OrderItem(UUID.randomUUID().toString().substring(0, 32), order, cartItem.getProductId(), cartItem.getColorId(), cartItem.getSizeId(), cartItem.getMerchantId(), cartItem.getQuantity(), cartItem.getPrice(), 3));
                merchantClient.updateRating(updateMerchantRating(cartItem.getMerchantId()));
            }
        }
        orderItemRepository.saveAll(orderItems);
        cartService.deleteCart(cartItems.get(0).getCart().getCartId());
        sendMail(order);
        return order;
    }

    @Override
    public List<OrderItemData> getOrderByUserId(String userId) {
        List<String> orderids=orderItemRepository.findOrderIdsByUserId(userId);
        List<OrderItem> orderItems=orderItemRepository.getOrderItems(orderids);
        List<OrderItemData> orderItemData=new ArrayList<>(orderItems.size());
        for(OrderItem orderItem:orderItems)
        {
            Product product=productClient.getProductById(orderItem.getProductId());
            Color color=productClient.getColorByColorId(orderItem.getColorId());
            Size size=productClient.getSizeBySizeId(orderItem.getSizeId());
            MerchantStore merchantStore=merchantClient.getMerchantById(orderItem.getMerchantId());
            orderItemData.add(new OrderItemData(product,size,color,merchantStore,orderItem));
        }
        return orderItemData;

    }

    @Override
    public List<OrderItemData> getOrderByMerchantId(String merchantId) {
//        System.out.println("called="+merchantId);
        List<OrderItem> orderItems=orderItemRepository.findByMerchantId(merchantId);
        List<OrderItemData>orderItemData=new ArrayList<>(orderItems.size());
        for(OrderItem orderItem:orderItems)
        {
            Product product=productClient.getProductById(orderItem.getProductId());
            Color color=productClient.getColorByColorId(orderItem.getColorId());
            Size size=productClient.getSizeBySizeId(orderItem.getSizeId());
            MerchantStore merchantStore=merchantClient.getMerchantById(orderItem.getMerchantId());
            orderItemData.add(new OrderItemData(product,size,color,merchantStore,orderItem));
        }
        return orderItemData;
    }

    @Override
    public void addRating(String orderItemId,double rating) {
        merchantClient.updateRating(updateMerchantRating(getOrderItemByOrderItemId(orderItemId).getMerchantId()));
        orderItemRepository.updateOrderItemRating(orderItemId,rating);
    }

    @Override
    public double getRating(String orderItemId) {
        return 0;
    }

    @Override
    public int getTotalOrderPlacedByMerchantId(String merchantId) {
        return orderItemRepository.findCountOfOrderItemByMerhcant_id(merchantId);
    }

    @Override
    public OrderItem getOrderItemByOrderItemId(String orderItemId) {
        return orderItemRepository.findById(orderItemId).get();
    }


    @Async
    @Override
    public void sendMail(Order order) {
        MailSenderThread mailSenderThread=new MailSenderThread(order);
        Thread thread=new Thread(mailSenderThread);
        thread.start();

    }

    @Override
    public Order buyNow(OrderItem orderItem,String userId) {
        Order order=new Order(UUID.randomUUID().toString().substring(0, 32),userId);
        try {

            orderRepository.save(order);
            sendMail(order);
            orderItem.setOrder(order);
            orderItem.setOrderItemId(UUID.randomUUID().toString().substring(0, 32));
            productClient.reduceQuantityByInventoryPk(orderItem.getProductId(),orderItem.getSizeId(),orderItem.getColorId(),orderItem.getMerchantId());
            orderItemRepository.save(orderItem);
            return order;
        }
        catch (Exception e)
        {

            return new Order();
        }
    }

    @Override
    public List<OrderItemData> getOrderHistory(String userId) {
        List<String>orderIds=orderRepository.findByUserId(userId);
        List<OrderItem>orderItems=orderItemRepository.getOrderItems(orderIds);
        List<OrderItemData> orderItemData=new ArrayList<>(orderItems.size());
        for(OrderItem orderItem:orderItems)
        {
            Product product=productClient.getProductById(orderItem.getProductId());
            Color color=productClient.getColorByColorId(orderItem.getColorId());
            Size size=productClient.getSizeBySizeId(orderItem.getSizeId());
            MerchantStore merchantStore=merchantClient.getMerchantById(orderItem.getMerchantId());
            orderItemData.add(new OrderItemData(product,size,color,merchantStore,orderItem));
        }
        return orderItemData;
    }

    @Override
    public RatingData updateMerchantRating(String merchantId) {
        return new RatingData(merchantId,orderItemRepository.setMerchantRating(merchantId));
    }

}
