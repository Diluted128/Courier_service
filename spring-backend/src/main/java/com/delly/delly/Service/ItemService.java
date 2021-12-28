package com.delly.delly.Service;

import com.delly.delly.dao.Item;
import com.delly.delly.repositories.ItemRepository;
import com.delly.delly.repositories.mapping.ItemWithCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class ItemService {

    ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<ItemWithCompany> getAllItems(){
        List<Object[]> objects = itemRepository.getAllItems();
        List<ItemWithCompany> companies = new LinkedList<>();
        System.out.println(objects.get(0)[1]);
        objects.forEach( (element) ->
                companies.add(new ItemWithCompany((int)element[0],(String)element[1],(String) element[2], (float) element[3], (String) element[4],(int)element[5]))
        );
        return companies;
    }

    public List<Item> getItemsByCompanyName(String companyItem){
        return itemRepository.getItemByCompanies(companyItem);
    }
}
