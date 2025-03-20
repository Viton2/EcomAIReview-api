package com.vitor.oliveira.ecomaireviewapi.controller;

import com.vitor.oliveira.ecomaireviewapi.DTO.forms.OrderForm;
import com.vitor.oliveira.ecomaireviewapi.model.Order;
import com.vitor.oliveira.ecomaireviewapi.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderForm form){
        return ResponseEntity.ok(orderService.create(form));
    }

//    @GetMapping
//    public ResponseEntity<String> getOrder(){
//        return ResponseEntity.ok("teste");
//    }
}
