package com.delly.delly.service;

import com.delly.delly.dao.CreditCard;
import com.delly.delly.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    CardRepository cardRepository;

    @Autowired
    public CreditCardService(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }

    public CreditCard getCreditCardByClientID(int ID){
        return cardRepository.getCreditCardByClientID(ID);
    }


}
