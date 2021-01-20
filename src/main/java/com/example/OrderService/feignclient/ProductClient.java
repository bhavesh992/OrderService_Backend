package com.example.OrderService.feignclient;


import com.example.OrderService.domain.*;
import com.example.OrderService.entity.OrderItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "ProductService", url = "http://localhost:9093/")
public interface ProductClient {

    @GetMapping(value = "/products/{productid}")
    public Product getProductById(@PathVariable("productid")String productid);

    @GetMapping("/inventory/color/{colorid}")
    public Color getColorByColorId(@PathVariable("colorid") int colorid);

    @GetMapping("/inventory/size/{sizeid}")
    public Size getSizeBySizeId(@PathVariable("sizeid") int sizeid);

    @GetMapping("/inventory/getproducts/{product_id}/{size_id}/{color_id}/{merchant_id}")
    public Inventory getProductsByInventory(@PathVariable("product_id") String product_id,@PathVariable("size_id") int size_id,@PathVariable("color_id") int color_id,@PathVariable("merchant_id") String merchant_id);



    @GetMapping("/inventory/reducequantity/{productId}/{sizeId}/{colorId}/{merchantId}")
    public ResponseEntity reduceQuantityByInventoryPk(@PathVariable("productId") String productId,@PathVariable("sizeId") int sizeId,@PathVariable("colorId") int colorId,@PathVariable("merchantId")String merchantId);
}