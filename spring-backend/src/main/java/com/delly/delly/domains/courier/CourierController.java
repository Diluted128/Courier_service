package com.delly.delly.domains.courier;

import com.delly.delly.domains.order.service.OrderService;
import com.delly.delly.domains.order.service.mapper.OrderWithAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin
@RequiredArgsConstructor
public class CourierController {

    CourierService courierService;
    OrderService orderService;

    @PostMapping("/login/courier")
    public ResponseEntity<String> clientLogin(@RequestBody Courier courier) {
        return courierService.getDeliverByEmailAndPassword(courier.getEmail(), courier.getPassword());
    }

    @GetMapping("/deliver/{ID}")
    public ResponseEntity<Courier> getOrderByDeliverID(@PathVariable int ID){
        return courierService.getDeliverByID(ID);
    }

    @PostMapping("/deliver/{ID}/withdrawal")
    public ResponseEntity<String> withdrawDeliverMoney(@PathVariable Integer ID){
        return courierService.withdrawDeliverMoney(ID);
    }

    // to change
    @GetMapping("deliver/{ID]/orders")
    public ResponseEntity<List<OrderWithAddress>> getOrdersByDeliverID(@PathVariable int ID) {
        return orderService.getOrderWithAddress(ID);
    }
}
