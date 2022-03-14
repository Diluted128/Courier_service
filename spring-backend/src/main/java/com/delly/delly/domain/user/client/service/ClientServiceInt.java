package com.delly.delly.domain.user.client.service;

import com.delly.delly.domain.user.client.Client;
import com.delly.delly.domain.user.client.controller.mapper.Location;
import com.delly.delly.domain.creditcard.CreditCard;
import org.springframework.http.ResponseEntity;

public interface ClientServiceInt {
    ResponseEntity<String> addClient(Client client);
    ResponseEntity<Integer> checkLoginCredentials(String email, String password);
    ResponseEntity<Client> getClientByID(int ID);
    ResponseEntity<String> updateClientData(int ID, Client client);
    ResponseEntity<String> updatePayment(int ID, CreditCard creditCard);
    ResponseEntity<String> saveLocation(int ID, Location location);

}
