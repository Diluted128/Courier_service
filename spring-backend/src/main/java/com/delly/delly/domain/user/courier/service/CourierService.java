package com.delly.delly.domain.user.courier.service;

import com.delly.delly.domain.role.RoleRepository;
import com.delly.delly.domain.user.courier.Courier;
import com.delly.delly.domain.user.courier.CourierRepository;
import com.delly.delly.domain.district.DistrictRepository;
import com.delly.delly.domain.order.Order;
import com.delly.delly.exception.exceptions.EntityAlreadyExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourierService{

    final CourierRepository courierRepository;
    final DistrictRepository districtRepository;
    final RoleRepository roleRepository;

    public Courier getCourier(String username){
        return courierRepository.getCourierByUsername(username);
    }

    public Set<Courier> getAllCouriers(){
        return new HashSet<>(courierRepository.findAll());
    }

    public Set<Order> getAllCourierOrders(String username){
        return courierRepository.getCourierByUsername(username).getOrders();
    }

    public String saveCourier(Courier courier){
        Optional<Courier> courierOptional = courierRepository.findCourierByUsername(courier.getUsername());

       if(courierOptional.isPresent())
           throw new EntityAlreadyExistException("Courier: " + courier.getUsername() + " already exists");

       courier.setDistrict(districtRepository.getDistinctByID(courier.getDistrict().getID()));
       courier.setRole(roleRepository.getById(courier.getRole().getId()));
       Courier courierSaved = courierRepository.save(courier);

       return "Courier: " + courierSaved.getId() + " successfully saved.";
    }

    public String withdrawCourierMoney(String username){
        Courier courier = courierRepository.getCourierByUsername(username);
        courier.setCash(0f);
        courierRepository.save(courier);
        return "Courier's " + username + " money have been withdrawn";
    }
}
