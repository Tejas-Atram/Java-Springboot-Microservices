package com.example.order_service;

//package com.example.orderservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final ProductClient productClient;

    // Inject the Feign client
    public OrderController(ProductClient productClient) {
        this.productClient = productClient;
    }

    @GetMapping("/create")
    public String createOrder() {
        // Here, Order Service calls Product Service!
        String products = productClient.getProducts();
        return "Order created successfully! Items in order: " + products;
    }
}
