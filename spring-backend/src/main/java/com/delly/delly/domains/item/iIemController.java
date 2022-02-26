package com.delly.delly.domains.item;

import com.delly.delly.domains.item.service.ItemService;
import com.delly.delly.domains.item.service.mapper.ItemWithCompany;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ItemWithCompany>> getAllProducts() {
        return itemService.getAllItems();
    }

    @GetMapping("/products/{companyName}")
    public ResponseEntity<List<Item>> getItemsByCompanyName(@PathVariable String companyName) {
        return itemService.getItemsByCompanyName(companyName);
    }
}
