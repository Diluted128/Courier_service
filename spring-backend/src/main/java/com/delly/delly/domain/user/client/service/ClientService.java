package com.delly.delly.domain.user.client.service;

import com.delly.delly.domain.address.Address;
import com.delly.delly.domain.address.AddressRepository;
import com.delly.delly.domain.user.client.Client;
import com.delly.delly.domain.user.client.ClientRepository;
import com.delly.delly.domain.order.Order;
import com.delly.delly.domain.role.Role;
import com.delly.delly.domain.role.RoleEnum;
import com.delly.delly.domain.role.RoleRepository;
import com.delly.delly.domain.creditcard.CreditCardRepository;
import com.delly.delly.domain.district.District;
import com.delly.delly.domain.district.DistrictRepository;
import com.delly.delly.exception.exceptions.EntityAlreadyExistException;
import com.delly.delly.exception.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientService{

    final CreditCardRepository creditCardRepository;
    final ClientRepository clientRepository;
    final AddressRepository addressRepository;
    final DistrictRepository districtRepository;
    final PasswordEncoder passwordEncoder;
    final RoleRepository roleRepository;


    public Client getClient(String username){
        return clientRepository.getClientByUsername(username);
    }

    public String addClient(Client client){

        if(clientRepository.findClientByUsername(client.getUsername()).isPresent()){
           throw new EntityAlreadyExistException(client.getUsername());
        }
        else{
            client.setPassword(passwordEncoder.encode(client.getPassword()));
            Role role = roleRepository.findByName(RoleEnum.CLIENT.toString()).orElseThrow(
                    () -> new EntityNotFoundException("Role doesn't exists")
            );

            client.setRole(role);
            clientRepository.save(client);
            return "Client: " + client.getId() + " created";
        }
    }

    public String updateClientData(String username, Client client){
        Client clientToUpdate = clientRepository.getClientByUsername(username);
        clientToUpdate.setFirstName(client.getFirstName());
        clientToUpdate.setLastName(client.getLastName());
        clientToUpdate.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(clientToUpdate);
        return "Client: " + client.getId() +  " data updated";
    }

    public String saveAddress(String username, Address address){
        Client client = clientRepository.getClientByUsername(username);

        Optional<District> district = districtRepository.findDistinctByName(address.getDistrict().getName());

        if(district.isPresent()){
            address.setDistrict(district.get());

            client.setAddress(address);

            Client savedClient = clientRepository.save(client);

            return "Address " + savedClient.getAddress().getID() + " successfully saved";
        }
        else{
            throw new EntityNotFoundException("District: " + address.getDistrict().getName() + " not found");
        }
    }

    public String updateAddress(String username, Address address){

        Client client = clientRepository.getClientByUsername(username);
        Address addressToUpdate = client.getAddress();

        Optional<District> district = districtRepository.findDistinctByName(address.getDistrict().getName());

        if(district.isPresent()){
            addressToUpdate.setStreet(address.getStreet());
            addressToUpdate.setTown(address.getTown());
            addressToUpdate.setLocation(address.getLocation());
            addressToUpdate.setFlatNumber(address.getFlatNumber());
            addressToUpdate.setLocalNumber(address.getLocalNumber());
            addressToUpdate.setPostalCode(address.getPostalCode());
            addressToUpdate.setDistrict(district.get());

            client.setAddress(addressToUpdate);

            Client savedClient = clientRepository.save(client);

            return "Address " + savedClient.getAddress().getID() + " successfully updated";
        }
        else{
            throw new EntityNotFoundException("District: " + address.getDistrict().getName() + " not found");
        }
    }

    public Set<Order> getClientOrders(String username) {
        return clientRepository.getClientByUsername(username).getOrders();
    }
}
