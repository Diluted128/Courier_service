package com.delly.delly.domain.user.courier;

import com.delly.delly.domain.order.Order;
import com.delly.delly.domain.user.courier.service.CourierService;
import com.delly.delly.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class CourierController {

    final CourierService courierService;
    final OrderService orderService;

    @GetMapping("/courier")
    public ResponseEntity<Courier> getCourier(Authentication authentication){
        return ResponseEntity.ok().body(courierService.getCourier(authentication.getName()));
    }

    @PostMapping("/courier")
    public ResponseEntity<String> saveCourier(@RequestBody Courier courier){
       return ResponseEntity.ok().body(courierService.saveCourier(courier));
    }

    @GetMapping("/couriers")
    public ResponseEntity<Set<Courier>> getAllCouriers(){
        return ResponseEntity.ok().body(courierService.getAllCouriers());
    }

    @GetMapping("/courier/orders")
    public ResponseEntity<Set<Order>> getAllCourierOrders(Authentication authentication){
       return ResponseEntity.ok().body(courierService.getAllCourierOrders(authentication.getName()));
    }

    @PostMapping("/courier/withdrawal")
    public ResponseEntity<String> withdrawCourierMoney(Authentication authentication){
        return ResponseEntity.ok().body(courierService.withdrawCourierMoney(authentication.getName()));
    }
}
