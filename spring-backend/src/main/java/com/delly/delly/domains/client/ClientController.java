package com.delly.delly.domains.client;

import com.delly.delly.domains.address.Address;
import com.delly.delly.domains.creditcard.CreditCard;
import com.delly.delly.domains.creditcard.CreditCardService;
import com.delly.delly.domains.order.OrderService;
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
    public void updateClientPayment(@PathVariable int ID, @RequestBody CreditCard creditCard) {
        clientService.updatePayment(ID, creditCard);
    }

    @GetMapping("/client/{ID}")
    public Client getClientByID(@PathVariable int ID) {
        return clientService.getClientByID(ID);
    }

    // ------------------------------
    @PutMapping("/client/{ID}")
    public void updateClientData(@PathVariable int ID, @RequestBody Client client) {
        clientService.saveExtendedPersonalInformation(ID, client);
    }

    @GetMapping("/client/{ID}/orders")
    public List<Orders> getClientOrders(@PathVariable int ID) {
        return orderService.getOrdersByClientID(ID);
    }

    @PostMapping("/client/{ID}/localization/{district}")
    public void saveLocation(@RequestBody Address address, @PathVariable int ID, @PathVariable int district) {
        clientService.saveLocation(ID, district, address);
    }

    @PostMapping("/client/{UID}/company/{CID}/order")
    public void saveOrder(@PathVariable int UID, @PathVariable int CID, @RequestBody Orders orders) {
        orderService.saveOrder(UID, CID, orders);
    }

    @PostMapping("client/{ID}/parcel/district/{districtID}/price/{price}")
    public void saveParcel(@PathVariable Integer ID, @PathVariable Integer districtID, @RequestBody Address address, @PathVariable Float price){
        orderService.saveParcelOrder(address, districtID, ID, price);
    }
}
