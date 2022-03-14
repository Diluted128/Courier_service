package com.delly.delly.domain.user.client.service;

import com.delly.delly.domain.address.Address;
import com.delly.delly.domain.address.AddressRepository;
import com.delly.delly.domain.role.RoleEnum;
import com.delly.delly.domain.role.RoleRepository;
import com.delly.delly.domain.user.client.Client;
import com.delly.delly.domain.user.client.ClientRepository;
import com.delly.delly.domain.user.client.controller.mapper.Location;
import com.delly.delly.domain.creditcard.CreditCard;
import com.delly.delly.domain.creditcard.CreditCardRepository;
import com.delly.delly.domain.district.District;
import com.delly.delly.domain.district.DistrictRepository;
import com.delly.delly.exception.exceptions.UserAlreadyExistException;
import com.delly.delly.exception.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService implements ClientServiceInt{

    final CreditCardRepository creditCardRepository;
    final ClientRepository clientRepository;
    final AddressRepository addressRepository;
    final DistrictRepository districtRepository;
    final PasswordEncoder passwordEncoder;
    final RoleRepository roleRepository;

    public ResponseEntity<String> addClient(Client client){

        if(clientRepository.findClientByLogin(client.getLogin()).isPresent()){
           throw new UserAlreadyExistException(client.getLogin());
        }
        else{
            client.setPassword(passwordEncoder.encode(client.getPassword()));
            client.setRole(roleRepository.findByName(RoleEnum.CLIENT.toString()).get());
            clientRepository.save(client);
            return new ResponseEntity<>("Client: " + client.getId() + " created", HttpStatus.OK);
        }
    }

    public ResponseEntity<Integer> checkLoginCredentials(String email, String password){
        Client client = clientRepository.findClientByLogin(email).orElseThrow(
                () -> new UserNotFoundException(email)
        );
        return new ResponseEntity<>(client.getId(), HttpStatus.OK);
    }

    public ResponseEntity<Client> getClientByID(int ID){
        return new ResponseEntity<>(clientRepository.getClientById(ID), HttpStatus.OK);
    }

    public ResponseEntity<String> updateClientData(int ID, Client client){
        Client client1 = clientRepository.getClientById(ID);
        client1.setFirstName(client.getFirstName());
        client1.setLastName(client.getLastName());
        client1.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(client1);
        return new ResponseEntity<>("Client: " + client.getId() +  " data updated", HttpStatus.OK);
    }

    public ResponseEntity<String> updatePayment(int ID, CreditCard creditCard){
        Client client =  clientRepository.getClientById(ID);
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
        Client client = clientRepository.getClientById(ID);
        District selectedDistrict = districtRepository.getDistinctByID(location.getDistrictID());
        Address newAddress = new Address(
                location.getFlatNumber(),
                location.getLocalNumber(),
                location.getPostalCode(),
                location.getStreet(),
                location.getTown(),
                selectedDistrict
        );

        addressRepository.save(newAddress);
        // this should be removed
        client.setAddress(newAddress);
        // this should be removed
        clientRepository.save(client);

        return new ResponseEntity<>("Location successfully saved", HttpStatus.OK);
    }
}
