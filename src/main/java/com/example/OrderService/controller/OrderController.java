package com.example.OrderService.controller;

import com.example.OrderService.domain.InventoryData;
import com.example.OrderService.domain.JwtToken;
import com.example.OrderService.domain.OrderData;
import com.example.OrderService.domain.RecommendedItem;
import com.example.OrderService.entity.OrderItem;
import com.example.OrderService.feignclient.ProductClient;
import com.example.OrderService.repository.OrderItemRepository;
import com.example.OrderService.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
   private  ProductClient productClient;
    @Autowired
   private  OrderItemRepository orderItemRepository;

    @GetMapping("/user/{userId}")
    public ResponseEntity getOrderByUserId(@PathVariable("userId") String userId){

        try
        {
            return new ResponseEntity(orderService.getOrderByUserId(userId),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage().toString(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/merchant/{merchantId}")
    public ResponseEntity getOrderByMerchantId(@PathVariable("merchantId") String merchantId){

        try
        {
            return new ResponseEntity(orderService.getOrderByMerchantId(merchantId),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage().toString(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/addrating/{orderItemId}/{rating}")
    public ResponseEntity addOrderItemRating(@PathVariable("orderItemId")String orderItemId,@PathVariable("rating") double rating){

        try
        {
            orderService.addRating(orderItemId,rating);
            return new ResponseEntity(new JwtToken("Rating Updated"),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage().toString(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/countorder/{merchantId}")
    public ResponseEntity getTotalOrderByMerchantId(@PathVariable("merchantId") String merchantId){
        try {
            return new ResponseEntity(orderService.getTotalOrderPlacedByMerchantId(merchantId),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/orderitem/{orderItemId}")
    public ResponseEntity getOrderItemByOrderItemId(@PathVariable("orderItemId") String orderItemId){
        try {
            return new ResponseEntity(orderService.getOrderItemByOrderItemId(orderItemId),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/add")
    public ResponseEntity saveOrder(@RequestBody OrderData orderData){
        try {
            return new ResponseEntity(orderService.saveOrder(orderData.getUserId(),orderData.getCartItemList()),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/buynow/{userId}")
    public ResponseEntity buyNow(@RequestBody OrderItem orderItem,@PathVariable("userId") String userId)
    {
        try
        {
            return new ResponseEntity(orderService.buyNow(orderItem,userId),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/orderhistory/{user_id}")
    public ResponseEntity orderHistory(@PathVariable("user_id")String userId)
    {
        try

        {

            return new ResponseEntity(orderService.getOrderHistory(userId),HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity(e.getMessage()+" **",HttpStatus.BAD_REQUEST);
        }
    }



}
