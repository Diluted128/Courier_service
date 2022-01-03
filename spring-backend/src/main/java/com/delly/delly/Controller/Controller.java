package com.delly.delly.Controller;

import com.delly.delly.Service.*;
import com.delly.delly.dao.*;
import com.delly.delly.repositories.mapping.ItemWithCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class Controller {

    ItemService itemService;
    ClientService clientService;
    CreditCardService creditCardService;
    DistrictService districtService;
    OrderService orderService;

    @Autowired
    public Controller(ItemService itemService, ClientService clientService, CreditCardService creditCardService,
                      DistrictService districtService, OrderService orderService){
        this.itemService = itemService;
        this.clientService = clientService;
        this.creditCardService = creditCardService;
        this.districtService = districtService;
        this.orderService = orderService;
    }

    @GetMapping("/products")
    public List<ItemWithCompany> getAllProducts(){
         return itemService.getAllItems();
    }

    @GetMapping("/products/{companyName}")
    public List<Item> getItemsByCompanyName(@PathVariable String companyName){
        return itemService.getItemsByCompanyName(companyName);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> clientRegister(@RequestBody Client client){
         return clientService.insertClientsCredential(client.getEmail(), client.getPassword());
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> clientLogin(@RequestBody Client client){
        return clientService.checkLoginCredentials(client.getEmail(), client.getPassword());
    }

    @PostMapping("/client/{ID}")
    public Client getClientByID(@PathVariable int ID){
        return clientService.getClientByID(ID);
    }

    @PostMapping("/client/refill/{ID}")
    public void refillPersonalData(@PathVariable int ID, @RequestBody Client client){
        clientService.saveExtendedPersonalInformation(ID, client.getFirstName(), client.getLastName(), client.getPhoneNumber());
    }

    @PostMapping("/client/{ID}/payment")
    public void savePayment(@PathVariable int ID, @RequestBody CreditCard creditCard){
        clientService.savePayment(ID,creditCard);
    }

    @GetMapping("/client/{ID}/payment")
    public CreditCard getCreditCardByClientID(@PathVariable int ID){
       return creditCardService.getCreditCardByClientID(ID);
    }

    @PostMapping("/client/{ID}/localization/{district}")
    public void saveLocation(@RequestBody Address address, @PathVariable int ID, @PathVariable int district){
       clientService.saveLocation(ID, district, address);
    }

    @GetMapping("/districts")
    public List<District> getAllDistricts(){
        return districtService.getAllDistricts();
    }

    @PostMapping("/client/{ClientID}/company/{CompanyID}/order")
    public void saveOrder(@PathVariable int ClientID, @PathVariable int CompanyID, @RequestBody List<Item> items){
        orderService.saveOrder(ClientID, CompanyID, items);
    }

    @GetMapping("client/{ID}/orders")
    public List<Orders> getOrderByID(@PathVariable int ID){
        return orderService.getOrdersByClientID(ID);
    }
}
