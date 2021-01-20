package com.example.OrderService.feignclient;

import com.example.OrderService.domain.MerchantStore;
import com.example.OrderService.domain.RatingData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "MerchantService", url = "http://localhost:9094/")
public interface MerchantClient {
    @GetMapping("/merchants/{merchant_id}")
    public MerchantStore getMerchantById(@PathVariable("merchant_id") String merchant_id);
    @PutMapping("/merchants/updaterating")
    public ResponseEntity updateRating(@RequestBody RatingData ratingData);
}
