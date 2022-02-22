package com.delly.delly.domains.courier;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class CourierController {

    DeliverService deliverService;

    @GetMapping("/deliver/{ID}")
    public Deliver getOrderByDeliverID(@PathVariable int ID){
        return deliverService.getDeliverByID(ID);
    }

    @PostMapping("/deliver/{ID}/withdrawal")
    public void withdrawDeliverMoney(@PathVariable Integer ID){
        deliverService.withdrawDeliverMoney(ID);
    }

    @PostMapping("/login/courier")
    public ResponseEntity<Map<String, String>> clientLogin(@RequestBody Deliver deliver) {
        return deliverService.getDeliverByEmailAndPassword(deliver.getEmail(), deliver.getPassword());
    }
}
