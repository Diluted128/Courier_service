package com.delly.delly.domains.item.service;

import com.delly.delly.domains.item.Item;
import com.delly.delly.domains.item.ItemRepository;
import com.delly.delly.domains.item.service.mapper.ItemWithCompany;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    ItemRepository itemRepository;

    public ResponseEntity<List<ItemWithCompany>> getAllItems(){
        List<Item> objects = itemRepository.findAll();
        List<ItemWithCompany> companies = new LinkedList<>();

        objects.forEach( (element) ->
                companies.add(new ItemWithCompany(
                        element.getID(),
                        element.getDescription(),
                        element.getName(),
                        element.getPrice(),
                        element.getSize(),
                        element.getCompany_id().getID()))
        );
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    public ResponseEntity<List<Item>> getItemsByCompanyName(String companyItem){
        return new ResponseEntity<>(itemRepository.getItemByCompanies(companyItem), HttpStatus.OK);
    }
}
