package com.delly.delly.Service;

import com.delly.delly.Service.mapping.OrderWithAddress;
import com.delly.delly.dao.*;
import com.delly.delly.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderService {

    ClientRepository clientRepository;
    CompanyRepository companyRepository;
    OrderRepository orderRepository;
    DeliverRepository deliverRepository;
    AddressRepository addressRepository;
    DepartmentRepository departmentRepository;

    @Autowired
    public OrderService(ClientRepository clientRepository, CompanyRepository companyRepository,
                        OrderRepository orderRepository, DeliverRepository deliverRepository,
                        AddressRepository addressRepository, DepartmentRepository departmentRepository) {

        this.clientRepository = clientRepository;
        this.companyRepository = companyRepository;
        this.orderRepository = orderRepository;
        this.deliverRepository = deliverRepository;
        this.addressRepository = addressRepository;
        this.departmentRepository = departmentRepository;
    }

    public void saveOrder(int ClientID, int CompanyID, Orders orders) {
        float totalPrice = orders.getItems().stream().map(Item::getPrice).reduce(0f, Float::sum);
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(dateFormat.format(date) + " " + totalPrice);

        orders.setCompany(companyRepository.getCompanyByCompanyID(CompanyID));
        orders.setDate(dateFormat.format(date));
        orders.setStatus("IN_PROGRESS");
        orders.setClient(clientRepository.getClientsByID(ClientID));

        orderRepository.save(orders);
    }

    public List<OrderWithAddress> getOrderWithAddress(int deliverID) {
        List<Orders> orders = orderRepository.getOrderByDeliverIDAndStatus(deliverID);

        List<OrderWithAddress> ordersWithAddress = new LinkedList<>();
        if (orders.size() != 0) {
            for (Orders order : orders) {
                Address addressClient = addressRepository.getAddressByClientID(order.getClient().getID());
                Address addressParcel = addressRepository.getAddressByCompanyIDAnAndDistrictID(order.getCompany().ID(), addressClient.getDistrict().getID());
                String courierLocation = deliverRepository.getDeliverByID(deliverID).getLocation();
                ordersWithAddress.add(new OrderWithAddress(order, addressClient, addressParcel, courierLocation));
            }
            return ordersWithAddress;
        } else return null;
    }

    public List<Orders> getOrdersByClientID(int ID) {
        return orderRepository.getOrdersByClientID(ID);
    }

    public Map<String, String> updateOrderStatus(Integer orderID, int distance, float reward, int deliverID) {

        Orders orders = orderRepository.getOrdersByID(orderID);
        Map<String, String> map =  new LinkedHashMap<>();
        System.out.println(orders.getID());
        if(orders.getStatus().equals("IN_PROGRESS")) {
            orders.setReward(reward);
            orders.setStatus("DELIVERED");
            orders.setDeliver(deliverRepository.getDeliverByID(deliverID));
            orderRepository.save(orders);

            Deliver deliver = orders.getDeliver();
            deliver.setDistance(deliver.getDistance() + distance);
            deliver.setCash(deliver.getCash() + reward + orders.getTip());
            deliverRepository.save(deliver);
            map.put("response", "true");
        }
        else{
            map.put("response", "false");
        }
        return map;
    }

    public List<Orders> getOrderByDeliverIDAndStatusDelivered(Integer deliverID) {
        return orderRepository.getOrderByDeliverIDAndStatusDelivered(deliverID);
    }
}

