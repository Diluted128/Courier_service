package com.delly.delly.domains.order;

import com.delly.delly.service.mapping.OrderWithAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class OrderController {

    OrderService orderService;

    @GetMapping("/order/deliver/{ID}")
    public List<OrderWithAddress> getOrdersByDeliverID(@PathVariable int ID) {
        return orderService.getOrderWithAddress(ID);
    }

    @PostMapping("/order/{ID}/distance/{distance}/reward/{reward}/deliver/{deliverID}")
    public Map<String, String> updateOrderStatus(@PathVariable int ID, @PathVariable int distance, @PathVariable Float reward, @PathVariable int deliverID){
        return orderService.updateOrderStatus(ID, distance, reward, deliverID);
    }

    @PostMapping("/orders/deliver/{ID}/delivered")
    public List<Orders> getOrderByDeliverIDAndStatusDelivered(@PathVariable int ID){
        return orderService.getOrderByDeliverIDAndStatusDelivered(ID);
    }
}
