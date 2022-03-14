package com.delly.delly.domain.user.courier.service;

import com.delly.delly.domain.user.courier.Courier;
import com.delly.delly.domain.user.courier.CourierRepository;
import com.delly.delly.exception.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourierService implements CourierServiceInt{

    CourierRepository courierRepository;

    public ResponseEntity<String> getDeliverByEmailAndPassword(String email, String password){

        Courier deliver = courierRepository.findDeliverByLoginAndPassword(email, password).orElseThrow(
                () -> new UserNotFoundException(email)
        );
        return new ResponseEntity<>(deliver.getId().toString(), HttpStatus.OK);
    }

    public ResponseEntity<Courier> getDeliverByID(int ID){
        return new ResponseEntity<>(courierRepository.getDeliverById(ID), HttpStatus.OK);
    }

    public ResponseEntity<String> withdrawDeliverMoney(int ID){
        Courier courier = courierRepository.getDeliverById(ID);
        courier.setCash(0f);
        courierRepository.save(courier);
        return new ResponseEntity<>("Courier with id: " + ID + "money have been withdrawn", HttpStatus.OK);
    }
}
