package com.delly.delly.Service;

import com.delly.delly.dao.Item;
import com.delly.delly.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public ItemService(){

    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public List<Item> getItemsByCompanyName(String companyItem){
        return itemRepository.getItemByCompanies(companyItem);
    }
}
