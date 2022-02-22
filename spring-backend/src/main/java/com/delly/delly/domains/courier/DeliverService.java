package com.delly.delly.domains.courier;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DeliverService {

    DeliverRepository deliverRepository;

    public ResponseEntity<Map<String,String>> getDeliverByEmailAndPassword(String email, String password){

        Integer ids = deliverRepository.getDeliverByEmailAndPassword(email, password).getID();
        Map<String, String> response = new LinkedHashMap<>();
        if(ids != null){
            response.put("ID",ids.toString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else{
            response.put("response", "Dane są nieprawidłowe");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    public Deliver getDeliverByID(int ID){
        return deliverRepository.getDeliverByID(ID);
    }

    public void withdrawDeliverMoney(int ID){
        Deliver deliver = deliverRepository.getDeliverByID(ID);
        deliver.setCash(0f);
        deliverRepository.save(deliver);
    }
}
