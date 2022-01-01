package com.delly.delly.Service;

import com.delly.delly.dao.Client;
import com.delly.delly.repositories.ClientRepository;
import com.delly.delly.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientService {

    ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public ResponseEntity<Map<String, String>> insertClientsCredential(String email, String password){

        Integer ids = clientRepository.getClientsByEmail(email);
        Map<String, String> response = new LinkedHashMap<>();
        if(ids == null) {
            Client client = new Client( email, null, null, password, null, null, null, null);
            clientRepository.save(client);
            response.put("response","Założono konto");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else {
            response.put("response", "Istnieje już użytkownik o podanym mailu");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Map<String,String>> checkLoginCredentials(String email, String password){
        Integer ids = clientRepository.getClientByEmailAndPassword(email, password);
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
}
