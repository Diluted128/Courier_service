package com.delly.delly.service;

import com.delly.delly.dao.Address;
import com.delly.delly.dao.Client;
import com.delly.delly.dao.CreditCard;
import com.delly.delly.dao.District;
import com.delly.delly.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ClientService {

    CardRepository cardRepository;
    ClientRepository clientRepository;
    AddressRepository addressRepository;
    DistrictRepository districtRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, CardRepository cardRepository,
                         AddressRepository addressRepository, DistrictRepository districtRepository){
        this.clientRepository = clientRepository;
        this.cardRepository = cardRepository;
        this.addressRepository = addressRepository;
        this.districtRepository = districtRepository;
    }

    public ResponseEntity<Map<String, String>> insertClientsCredential(String email, String password){

        Integer ids = clientRepository.getClientsByEmail(email);
        Map<String, String> response = new LinkedHashMap<>();
        if(ids == null) {
            Client client = new Client( email, null, null, password, null, null, null, null);
            clientRepository.save(client);
            response.put("response","Założono konto");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else {
            response.put("response", "Istnieje już użytkownik o podanym mailu");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Map<String,String>> checkLoginCredentials(String email, String password){
        Integer ids = clientRepository.getClientByEmailAndPassword(email, password);
        Map<String, String> response = new LinkedHashMap<>();
        if(ids != null){
            response.put("ID",ids.toString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else{
            response.put("response", "Dane są nieprawidłowe");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    public Client getClientByID(int ID){
        return clientRepository.getClientsByID(ID);
    }

    public void saveExtendedPersonalInformation(int ID, String name, String surname, String phoneNumber){
        System.out.println(ID + name + surname + phoneNumber);
        clientRepository.saveClientsExtendedPersonalData(ID, name, surname, phoneNumber);
    }

    public void savePayment(int ID, CreditCard creditCard){
        Client client =  clientRepository.getClientsByID(ID);
        if(client.getCreditCard() == null){
            cardRepository.save(creditCard);
            client.setCreditCard(creditCard);
            clientRepository.save(client);
        }
        else {
            creditCard.setID(client.getCreditCard().getID());
            client.setCreditCard(creditCard);
            clientRepository.save(client);
            cardRepository.save(creditCard);
        }
    }

    public void saveLocation(int ID, int district, Address address){
        Client client = getClientByID(ID);
        District selectedDistrict = districtRepository.getDistrictByID(district);
        System.out.println(selectedDistrict.getID() + " " + selectedDistrict.getName());
        address.setDistrict(selectedDistrict);

        if(client.getAddress() == null){
            System.out.println("TAK");
            address.setID(addressRepository.getMaxID() + 1);
            addressRepository.saveAddress(address.getID(), address.getFlatNumber(),
                    address.getLocalNumber(), address.getLocation(), address.getPostalCode(), address.getStreet(), address.getTown(), address.getDistrict().getID());
            client.setAddress(address);
        }
        else{
            System.out.println("NIE");
            address.setID(client.getAddress().getID());
            addressRepository.save(address);
            client.setAddress(address);
        }
        clientRepository.save(client);
    }
}