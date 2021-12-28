package com.delly.delly.Controller;

import com.delly.delly.Service.ItemService;
import com.delly.delly.dao.Item;
import com.delly.delly.repositories.mapping.ItemWithCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class Controller {

    ItemService itemService;

    @Autowired
    public Controller(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping("/products")
    public List<ItemWithCompany> getAllProducts(){
         return itemService.getAllItems();
    }

    @GetMapping("products/{companyName}")
    public List<Item> getItemsByCompanyName(@PathVariable String companyName){
        return itemService.getItemsByCompanyName(companyName);
    }
}
