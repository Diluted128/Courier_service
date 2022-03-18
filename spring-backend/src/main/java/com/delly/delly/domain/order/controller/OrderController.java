package com.delly.delly.domain.order.controller;

import com.delly.delly.domain.order.Order;
import com.delly.delly.domain.order.service.OrderService;
import com.delly.delly.domain.order.service.utils.CourierReward;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class OrderController {

    final OrderService orderService;


    @GetMapping("/orders")
    public ResponseEntity<Set<Order>> getAllOrders(){
         return ResponseEntity.ok().body(orderService.getAllOrders());
    }

    @PostMapping("/order")
    public ResponseEntity<String> saveProductOrder(Authentication authentication, @RequestBody Order order) {
        return ResponseEntity.ok().body(orderService.saveOrder(authentication.getName(), order));
    }

    @PutMapping("/order/{ID}")
    public ResponseEntity<String> updateOrderDetails(Authentication authentication, @PathVariable int ID){
        return ResponseEntity.ok().body(orderService.updateOrderDetails(authentication.getName(), ID));
    }

    @PutMapping("/order/realization")
    public ResponseEntity<String> deliverOrder(Authentication authentication, @RequestBody CourierReward courierReward){
         return ResponseEntity.ok().body(orderService.deliverOrder(authentication.getName(), courierReward));
    }
}
