package com.delly.delly.domains.item;

import com.delly.delly.repositories.mapping.ItemWithCompany;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class iIemController {

    ItemService itemService;

    @GetMapping("/products")
    public List<ItemWithCompany> getAllProducts() {
        return itemService.getAllItems();
    }

    @GetMapping("/products/{companyName}")
    public List<Item> getItemsByCompanyName(@PathVariable String companyName) {
        return itemService.getItemsByCompanyName(companyName);
    }
}
