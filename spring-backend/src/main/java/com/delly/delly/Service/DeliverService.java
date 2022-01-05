package com.delly.delly.Service;

import com.delly.delly.dao.Deliver;
import com.delly.delly.repositories.DeliverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DeliverService {

    DeliverRepository deliverRepository;

    @Autowired
    public DeliverService(DeliverRepository deliverRepository) {
        this.deliverRepository = deliverRepository;
    }

    public ResponseEntity<Map<String,String>> getDeliverByEmailAndPassword(String email, String password){

        Integer ids = deliverRepository.getDeliverByEmailAndPassword(email, password);
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


}
