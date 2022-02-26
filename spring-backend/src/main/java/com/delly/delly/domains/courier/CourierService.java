package com.delly.delly.domains.courier;

import com.delly.delly.exception.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourierService {

    CourierRepository courierRepository;

    public ResponseEntity<String> getDeliverByEmailAndPassword(String email, String password){

        Courier deliver = courierRepository.findDeliverByEmailAndPassword(email, password).orElseThrow(
                UserNotFoundException::new
        );
        return new ResponseEntity<>(deliver.getID().toString(), HttpStatus.OK);
    }

    public ResponseEntity<Courier> getDeliverByID(int ID){
        return new ResponseEntity<>(courierRepository.getDeliverByID(ID), HttpStatus.OK);
    }

    public ResponseEntity<String> withdrawDeliverMoney(int ID){
        Courier courier = courierRepository.getDeliverByID(ID);
        courier.setCash(0f);
        courierRepository.save(courier);
        return new ResponseEntity<>("Courier with id: " + ID + "money have been withdrawn", HttpStatus.OK);
    }
}
