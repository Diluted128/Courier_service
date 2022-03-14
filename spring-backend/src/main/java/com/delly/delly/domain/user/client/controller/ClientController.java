package com.delly.delly.domain.user.client.controller;

import com.delly.delly.domain.user.client.controller.mapper.CompanyOrder;
import com.delly.delly.domain.user.client.Client;
import com.delly.delly.domain.user.client.service.ClientService;
import com.delly.delly.domain.user.client.controller.mapper.Location;
import com.delly.delly.domain.user.client.controller.mapper.Parcel;
import com.delly.delly.domain.creditcard.CreditCard;
import com.delly.delly.domain.creditcard.CreditCardService;
import com.delly.delly.domain.order.service.OrderService;
import com.delly.delly.domain.order.Orders;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {

    ClientService clientService;
    OrderService orderService;
    CreditCardService creditCardService;

    @PostMapping("/register")
    public ResponseEntity<String> clientRegister(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PostMapping("/login")
    public ResponseEntity<Integer> clientLogin(@RequestBody Client client) {
        return clientService.checkLoginCredentials(client.getLogin(), client.getPassword());
    }

    @GetMapping("/{ID}/payment")
    public ResponseEntity<CreditCard> getClientPayment(@PathVariable int ID) {
        return creditCardService.getCreditCardByClientID(ID);
    }

    @PutMapping("/{ID}/payment")
    public ResponseEntity<String> updateClientPayment(@PathVariable int ID, @RequestBody CreditCard creditCard) {
        return clientService.updatePayment(ID, creditCard);
    }

    @GetMapping("/{ID}")
    public ResponseEntity<Client> getClientByID(@PathVariable int ID) {
        return clientService.getClientByID(ID);
    }

    @GetMapping("/{ID}/orders")
    public ResponseEntity<List<Orders>> getClientOrders(@PathVariable int ID) {
        return orderService.getOrdersByClientID(ID);
    }

    @PutMapping("/{ID}/personal")
    public ResponseEntity<String> updateClientPersonalData(@PathVariable int ID, @RequestBody Client client) {
        return clientService.updateClientData(ID, client);
    }

    @PutMapping("/{ID}/location")
    public ResponseEntity<String> saveLocation(@RequestBody Location location, @PathVariable int ID) {
        return clientService.saveLocation(ID, location);
    }

    @PostMapping("/{ID}/order")
    public ResponseEntity<String> saveNormalOrder(@PathVariable int ID, @RequestBody CompanyOrder companyOrder) {
        return orderService.saveOrder(ID, companyOrder);
    }

    @PostMapping("/{ID}/parcel")
    public ResponseEntity<String> addParcelOrder(@PathVariable Integer ID, @RequestBody Parcel parcel){
        return orderService.saveParcelOrder(ID, parcel);
    }
}
