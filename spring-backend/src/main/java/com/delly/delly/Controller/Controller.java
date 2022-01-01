package com.delly.delly.Controller;

import com.delly.delly.Service.ClientService;
import com.delly.delly.Service.ItemService;
import com.delly.delly.dao.Client;
import com.delly.delly.dao.Item;
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

    @Autowired
    public Controller(ItemService itemService, ClientService clientService){
        this.itemService = itemService;
        this.clientService = clientService;
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
}
