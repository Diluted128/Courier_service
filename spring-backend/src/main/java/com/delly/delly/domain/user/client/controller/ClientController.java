package com.delly.delly.domain.user.client.controller;

import com.delly.delly.domain.address.Address;
import com.delly.delly.domain.order.Order;
import com.delly.delly.domain.user.client.Client;
import com.delly.delly.domain.user.client.service.ClientService;
import com.delly.delly.domain.creditcard.CreditCard;
import com.delly.delly.domain.creditcard.CreditCardService;
import com.delly.delly.domain.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {

    ClientService clientService;
    OrderService orderService;
    CreditCardService creditCardService;

    @GetMapping("")
    public ResponseEntity<Client> getClient(Authentication authentication){
         return ResponseEntity.ok().body(clientService.getClient(authentication.getName()));
    }

    @PostMapping("")
    public ResponseEntity<String> registerClient(@RequestBody Client client) {
        return ResponseEntity.ok().body(clientService.addClient(client));
    }

    @PutMapping("")
    public ResponseEntity<String> updateClientPersonalData(Authentication authentication, @RequestBody Client client) {
        return ResponseEntity.ok().body(clientService.updateClientData(authentication.getName(), client));
    }

    @PostMapping("/payment")
    public ResponseEntity<String> saveClientPayment(Authentication authentication, @RequestBody CreditCard creditCard) {
        return ResponseEntity.ok().body(creditCardService.savePayment(authentication.getName(), creditCard));
    }

    @PutMapping("/payment/{ID}")
    public ResponseEntity<String> updateClientPayment(Authentication authentication, @RequestBody CreditCard creditCard, @PathVariable int ID) {
        return ResponseEntity.ok().body(creditCardService.updatePayment(authentication.getName(), creditCard, ID));
    }

    @DeleteMapping("/payment/{ID}")
    public ResponseEntity<String> deleteClientPayment(Authentication authentication, @PathVariable int ID){
        return ResponseEntity.ok().body(creditCardService.deletePayment(authentication.getName(), ID));
    }

    @PostMapping("/address")
    public ResponseEntity<String> saveClientAddress(Authentication authentication, @RequestBody Address address) {
        return ResponseEntity.ok().body(clientService.saveAddress(authentication.getName(), address));
    }

    @PutMapping("/address")
    public ResponseEntity<String> updateClientAddress(Authentication authentication, @RequestBody Address address) {
        return ResponseEntity.ok().body(clientService.updateAddress(authentication.getName(), address));
    }

    @GetMapping("/orders")
    public ResponseEntity<Set<Order>> getClientOrders(Authentication authentication) {
        return ResponseEntity.ok().body(clientService.getClientOrders(authentication.getName()));
    }
}
