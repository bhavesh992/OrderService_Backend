package com.example.OrderService.exception;

public class MaxOrderLimitReach extends Exception {
    public MaxOrderLimitReach(String message) {
        super(message);
    }
}
