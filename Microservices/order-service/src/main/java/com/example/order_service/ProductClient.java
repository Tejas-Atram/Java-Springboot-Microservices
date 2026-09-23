package com.example.order_service;

//package com.example.orderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product-service") // Name matches the application.name in Product Service
public interface ProductClient {

    @GetMapping("/products")
    String getProducts();
}
