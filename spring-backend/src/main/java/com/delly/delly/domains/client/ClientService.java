package com.delly.delly.domains.client;

import com.delly.delly.domains.address.Address;
import com.delly.delly.domains.address.AddressRepository;
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
            return new ResponseEntity<>("Client created", HttpStatus.OK);
        }
    }

    public ResponseEntity<String> checkLoginCredentials(String email, String password){
        Client client = clientRepository.findClientByEmailAndPassword(email, password).orElseThrow(
                UserNotFoundException::new
        );
        return new ResponseEntity<>(client.getID().toString(), HttpStatus.OK);
    }

    public Client getClientByID(int ID){
        return clientRepository.getClientByID(ID);
    }

    public void saveExtendedPersonalInformation(int ID, Client client){
        Client client1 = clientRepository.getClientByID(ID);
        client1.setAddress();
        clientRepository.saveClientsExtendedPersonalData(ID, client);
    }

    public void updatePayment(int ID, CreditCard creditCard){
        Client client =  clientRepository.getClientByID(ID);
        if(client.getCreditCard() == null){
            creditCardRepository.save(creditCard);
            client.setCreditCard(creditCard);
            clientRepository.save(client);
        }
        else {
            creditCard.setID(client.getCreditCard().getID());
            client.setCreditCard(creditCard);
            clientRepository.save(client);
            creditCardRepository.save(creditCard);
        }
    }

    public void saveLocation(int ID, int district, Address address){
        Client client = getClientByID(ID);
        District selectedDistrict = districtRepository.getDistinctByID(district);
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
