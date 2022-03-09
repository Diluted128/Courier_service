package com.delly.delly.domains.courier;

import com.delly.delly.domains.order.service.OrderService;
import com.delly.delly.domains.order.service.mapper.OrderWithAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, path = "/courier")
public class CourierController {

    CourierService courierService;
    OrderService orderService;

    @PostMapping("login")
    public ResponseEntity<String> clientLogin(@RequestBody Courier courier) {
        return courierService.getDeliverByEmailAndPassword(courier.getEmail(), courier.getPassword());
    }

    @GetMapping("/{ID}")
    public ResponseEntity<Courier> getOrderByDeliverID(@PathVariable int ID){
        return courierService.getDeliverByID(ID);
    }

    @PostMapping("/{ID}/withdrawal")
    public ResponseEntity<String> withdrawDeliverMoney(@PathVariable Integer ID){
        return courierService.withdrawDeliverMoney(ID);
    }

    @GetMapping("/{ID]/orders")
    public ResponseEntity<List<OrderWithAddress>> getOrdersByDeliverID(@PathVariable int ID) {
        return orderService.getOrderWithAddress(ID);
    }
}
