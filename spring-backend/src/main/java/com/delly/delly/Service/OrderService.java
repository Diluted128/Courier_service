package com.delly.delly.Service;

import com.delly.delly.Service.mapping.OrderWithAddress;
import com.delly.delly.dao.*;
import com.delly.delly.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    public void saveOrder(int ClientID, int CompanyID, Orders orders){
        float totalPrice = orders.getItems().stream().map(Item::getPrice).reduce(0f, Float::sum);
        Date date = new Date();
        DateFormat dateFormat =  new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(dateFormat.format(date) + " " + totalPrice);
        List<Deliver> delivers = deliverRepository.getDeliverByDistrictID(clientRepository.getDistrictIDByClientID(ClientID));

        System.out.println(delivers.get(0));
        orders.setCompany(companyRepository.getCompanyByCompanyID(CompanyID));
        orders.setDate(dateFormat.format(date));
        orders.setStatus("IN_PROGRESS");
        orders.setClient(clientRepository.getClientsByID(ClientID));
        orders.setDeliver(delivers.get(0));

        orderRepository.save(orders);
    }

    public OrderWithAddress getOrderWithAddress(int deliverID){
        Orders orders = orderRepository.getOrderByDeliverIDAndStatus(deliverID);

        if(orders != null) {
            Address addressClient = addressRepository.getAddressByClientID(orders.getClient().getID());
            Address addressParcel = addressRepository.getAddressByCompanyIDAnAndDistrictID(orders.getCompany().ID(), addressClient.getDistrict().getID());
            String courierLocation = deliverRepository.getDeliverByID(deliverID).getLocation();

            System.out.println(addressClient.getID() + " " + addressClient.getStreet() + " " + addressClient.getPostalCode());
            System.out.println(addressParcel.getID() + " " + addressParcel.getStreet() + " " + addressParcel.getPostalCode());

            OrderWithAddress orderWithAddress = new OrderWithAddress(orders, addressClient, addressParcel, courierLocation);
            return orderWithAddress;
        }
        else{
            return null;
        }
    }

    public List<Orders> getOrdersByClientID(int ID){
        return orderRepository.getOrdersByClientID(ID);
    }

    public void updateOrderStatus(Integer orderID, int distance, float reward){

        Orders orders = orderRepository.getOrdersByID(orderID);
        orders.setReward(reward);
        orders.setStatus("DELIVERED");
        orderRepository.save(orders);

        Deliver deliver = orders.getDeliver();
        deliver.setDistance(deliver.getDistance() + distance);
        deliver.setCash(deliver.getCash() + reward + orders.getTip());
        deliverRepository.save(deliver);
    }

    public List<Orders> getOrderByDeliverIDAndStatusDelivered(Integer deliverID){
        return orderRepository.getOrderByDeliverIDAndStatusDelivered(deliverID);
    }
}
