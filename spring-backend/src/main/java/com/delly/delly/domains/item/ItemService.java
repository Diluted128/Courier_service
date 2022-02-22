package com.delly.delly.domains.item;

import com.delly.delly.repositories.mapping.ItemWithCompany;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    ItemRepository itemRepository;

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
