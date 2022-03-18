package com.delly.delly.domain.order.service;

import com.delly.delly.domain.department.DepartmentRepository;
import com.delly.delly.domain.item.ItemRepository;
import com.delly.delly.domain.order.Order;
import com.delly.delly.domain.item.Item;
import com.delly.delly.domain.address.AddressRepository;
import com.delly.delly.domain.order.service.utils.CourierReward;
import com.delly.delly.domain.user.client.Client;
import com.delly.delly.domain.user.client.ClientRepository;
import com.delly.delly.domain.company.CompanyRepository;
import com.delly.delly.domain.user.courier.Courier;
import com.delly.delly.domain.user.courier.CourierRepository;
import com.delly.delly.domain.district.DistrictRepository;
import com.delly.delly.domain.order.OrderRepository;
import com.delly.delly.exception.exceptions.EntityLimitException;
import com.delly.delly.exception.exceptions.EntityNotFoundException;
import com.delly.delly.exception.exceptions.EntityStatusException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService{

    final ClientRepository clientRepository;
    final CompanyRepository companyRepository;
    final OrderRepository orderRepository;
    final CourierRepository courierRepository;
    final AddressRepository addressRepository;
    final DistrictRepository districtRepository;
    final DepartmentRepository departmentRepository;
    final ItemRepository itemRepository;

    public Set<Order> getAllOrders(){
        return new HashSet<>(orderRepository.findAll());
    }

    public String saveOrder(String username, Order order) {

        Client client = clientRepository.getClientByUsername(username);

        if(client.getOrders().stream().filter(element -> element.getStatus().equals(OrderType.ACCEPTED.toString()) ||
                        element.getStatus().equals(OrderType.IN_PROGRESS.toString())).count() > 2){
            throw new EntityLimitException("Client: " +  client.getId() + " can have up to three unrealized orders");
        }
        else{
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            order.setItems(
                    order.getItems().stream()
                            .map(item -> itemRepository.getItemByID(item.getID()))
                            .collect(Collectors.toSet())
            );

            float totalPrice = order.getItems().stream()
                    .map(Item::getPrice)
                    .reduce(0f, Float::sum);

            order.setDepartment(departmentRepository.getDepartmentByID(order.getDepartment().getID()));
            order.setDate(dateFormat.format(date));
            order.setStatus(OrderType.ACCEPTED.toString());
            order.setClient(clientRepository.getClientByUsername(username));
            order.setPrice(totalPrice);

            Order savedOrder = orderRepository.save(order);

            return "Order " + savedOrder.getID() + " successfully saved";
        }
    }

    public String updateOrderDetails(String username, int id) {

        Optional<Order> orderOptional = orderRepository.findOrderByID(id);

        if(orderOptional.isPresent()) {

            Order order = orderOptional.get();
            Courier courier = courierRepository.getCourierByUsername(username);

            if(courier.getOrders().size() == 1)
                throw new EntityLimitException("Courier: " + courier.getId() + " has already order dedicated to realization.");
            if (order.getStatus().equals(OrderType.ACCEPTED.toString())) {
                order.setStatus(OrderType.IN_PROGRESS.toString());
                order.setCourier(courier);
                orderRepository.save(order);
                return "Courier: " + courier.getId() + " has been set for order: " + id + ".";
            } else
                throw new EntityStatusException("Order: " + id + " has been already delivered, canceled or in progress.");
        }
        else
            throw new EntityNotFoundException("Order: " + id + " not found.");

    }

    public String deliverOrder(String username, CourierReward courierReward){

        Optional<Order> orderToUpdateOptional = orderRepository.findOrderByCourierUsernameAndStatus(username, "IN_PROGRESS");
        Courier courier = courierRepository.getCourierByUsername(username);

        if(orderToUpdateOptional.isPresent()){
            Order orderToUpdate = orderToUpdateOptional.get();
            orderToUpdate.setStatus(OrderType.DELIVERED.toString());
            courier.setCash(courier.getCash() + courierReward.getCash()+ orderToUpdate.getTip());
            courier.setDistance(courier.getDistance() + courierReward.getDistance());
            courierRepository.save(courier);

            return "Order: " + orderToUpdate.getID() + " has been delivered.";
        }
        else
            throw new EntityStatusException("There is no active order for courier: " + courier.getId());

    }
}

