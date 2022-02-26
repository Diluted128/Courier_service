package com.delly.delly.domains.client.controller;

import com.delly.delly.domains.client.Client;
import com.delly.delly.domains.client.ClientService;
import com.delly.delly.domains.client.controller.mapper.CompanyOrder;
import com.delly.delly.domains.client.controller.mapper.Location;
import com.delly.delly.domains.client.controller.mapper.Parcel;
import com.delly.delly.domains.creditcard.CreditCard;
import com.delly.delly.domains.creditcard.CreditCardService;
import com.delly.delly.domains.order.service.OrderService;
import com.delly.delly.domains.order.Orders;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ClientController {

    ClientService clientService;
    OrderService orderService;
    CreditCardService creditCardService;

    @PostMapping("/register")
    public ResponseEntity<String> clientRegister(@RequestBody Client client) {
        return clientService.insertClientsCredential(client.getEmail(), client.getPassword());
    }

    @PostMapping("client/login")
    public ResponseEntity<String> clientLogin(@RequestBody Client client) {
        return clientService.checkLoginCredentials(client.getEmail(), client.getPassword());
    }

    @GetMapping("/client/{ID}/payment")
    public ResponseEntity<CreditCard> getClientPayment(@PathVariable int ID) {
        return creditCardService.getCreditCardByClientID(ID);
    }

    @PutMapping("/client/{ID}/payment")
    public ResponseEntity<String> updateClientPayment(@PathVariable int ID, @RequestBody CreditCard creditCard) {
        return clientService.updatePayment(ID, creditCard);
    }

    @GetMapping("/client/{ID}")
    public ResponseEntity<Client> getClientByID(@PathVariable int ID) {
        return clientService.getClientByID(ID);
    }

    @GetMapping("/client/{ID}/orders")
    public ResponseEntity<List<Orders>> getClientOrders(@PathVariable int ID) {
        return orderService.getOrdersByClientID(ID);
    }

    @PutMapping("/client/{ID}/personal")
    public ResponseEntity<String> updateClientPersonalData(@PathVariable int ID, @RequestBody Client client) {
        return clientService.updateClientData(ID, client);
    }

    @PutMapping("/client/{ID}/location")
    public ResponseEntity<String> saveLocation(@RequestBody Location location, @PathVariable int ID) {
        return clientService.saveLocation(ID, location);
    }

    @PostMapping("/client/{ID}/order")
    public ResponseEntity<String> saveNormalOrder(@PathVariable int ID, @RequestBody CompanyOrder companyOrder) {
        return orderService.saveOrder(ID, companyOrder);
    }

    @PostMapping("client/{ID}/parcel")
    public ResponseEntity<String> addParcelOrder(@PathVariable Integer ID, @RequestBody Parcel parcel){
        return orderService.saveParcelOrder(ID, parcel);
    }
}
