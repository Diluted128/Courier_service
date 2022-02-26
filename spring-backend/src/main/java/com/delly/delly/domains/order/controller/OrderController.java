package com.delly.delly.domains.order.controller;

import com.delly.delly.domains.order.Orders;
import com.delly.delly.domains.order.controller.mapper.OrderUtils;
import com.delly.delly.domains.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class OrderController {

    OrderService orderService;

    @PutMapping("/order/{ID}")
    public ResponseEntity<String> updateOrderStatus(@PathVariable int ID, @RequestBody OrderUtils orderUtils){
        return orderService.updateOrderStatus(ID, orderUtils);
    }

    @GetMapping("/orders/delivered")
    public ResponseEntity<List<Orders>> getOrderByDeliverIDAndStatusDelivered(@RequestBody int courierID){
        return orderService.getOrderByDeliverIDAndStatusDelivered(courierID);
    }
}
