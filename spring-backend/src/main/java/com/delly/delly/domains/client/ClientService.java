package com.delly.delly.domains.client;

import com.delly.delly.domains.address.Address;
import com.delly.delly.domains.address.AddressRepository;
import com.delly.delly.domains.client.controller.mapper.Location;
import com.delly.delly.domains.creditcard.CreditCard;
import com.delly.delly.domains.creditcard.CreditCardRepository;
import com.delly.delly.domains.district.District;
import com.delly.delly.domains.district.DistrictRepository;
import com.delly.delly.exception.exceptions.UserAlreadyExistException;
import com.delly.delly.exception.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ClientService {

    CreditCardRepository creditCardRepository;
    ClientRepository clientRepository;
    AddressRepository addressRepository;
    DistrictRepository districtRepository;

    public ResponseEntity<String> insertClientsCredential(String email, String password){

        if(clientRepository.findClientByEmail(email).isPresent()){
           throw new UserAlreadyExistException(email);
        }
        else{
            Client client = new Client(
                    email,
                    null,
                    null,
                    password,
                    null,
                    null,
                    null,
                    null);

            clientRepository.save(client);
            return new ResponseEntity<>("Client: " + client.getID() + " created", HttpStatus.OK);
        }
    }

    public ResponseEntity<String> checkLoginCredentials(String email, String password){
        Client client = clientRepository.findClientByEmailAndPassword(email, password).orElseThrow(
                UserNotFoundException::new
        );
        return new ResponseEntity<>(client.getID().toString(), HttpStatus.OK);
    }

    public ResponseEntity<Client> getClientByID(int ID){
        return new ResponseEntity<>(clientRepository.getClientByID(ID), HttpStatus.OK);
    }

    public ResponseEntity<String> updateClientData(int ID, Client client){
        Client client1 = clientRepository.getClientByID(ID);
        client1.setFirstName(client.getFirstName());
        client1.setLastName(client.getLastName());
        client1.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(client1);
        return new ResponseEntity<>("Client: " + client.getID() +  " data updated", HttpStatus.OK);
    }

    public ResponseEntity<String> updatePayment(int ID, CreditCard creditCard){
        Client client =  clientRepository.getClientByID(ID);
        if(client.getCreditCard() == null){
            creditCardRepository.save(creditCard);
            client.setCreditCard(creditCard);
            clientRepository.save(client);
            return new ResponseEntity<>("Payment: " + creditCard.getID()  + " has been set", HttpStatus.OK);
        }
        else {
            creditCard.setID(client.getCreditCard().getID());
            client.setCreditCard(creditCard);
            clientRepository.save(client);
            creditCardRepository.save(creditCard);
            return new ResponseEntity<>("Payment: " + creditCard.getID()  + " has been updated", HttpStatus.OK);
        }
    }

    public ResponseEntity<String> saveLocation(int ID, Location location){
        Client client = clientRepository.getClientByID(ID);
        District selectedDistrict = districtRepository.getDistinctByID(location.getDistrictID());
        Address newAddress = new Address(
                location.getFlatNumber(),
                location.getLocalNumber(),
                location.getPostalCode(),
                location.getStreet(),
                location.getTown(),
                selectedDistrict
        );

        if(client.getAddress() == null){
            newAddress.setID(addressRepository.getMaxID() + 1);
        }
        else{
            newAddress.setID(client.getAddress().getID());
        }
        addressRepository.save(newAddress);
        // this should be removed
        client.setAddress(newAddress);
        // this should be removed
        clientRepository.save(client);

        return new ResponseEntity<>("Location successfully saved", HttpStatus.OK);
    }
}
