package com.delly.delly.domain.creditcard;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditCardService {

    CreditCardRepository creditCardRepository;

    public ResponseEntity<CreditCard> getCreditCardByClientID(int ID){
        return new ResponseEntity<>(creditCardRepository.getCreditCardByClientID(ID), HttpStatus.OK);
    }

}
