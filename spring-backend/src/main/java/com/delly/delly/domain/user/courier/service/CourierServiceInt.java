package com.delly.delly.domain.user.courier.service;

import com.delly.delly.domain.user.courier.Courier;
import org.springframework.http.ResponseEntity;

public interface CourierServiceInt {
    ResponseEntity<String> getDeliverByEmailAndPassword(String email, String password);
    ResponseEntity<Courier> getDeliverByID(int ID);
    ResponseEntity<String> withdrawDeliverMoney(int ID);
}
