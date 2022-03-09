package com.delly.delly.domains.order.service;

import com.delly.delly.domains.client.controller.mapper.CompanyOrder;
import com.delly.delly.domains.client.controller.mapper.Parcel;
import com.delly.delly.domains.item.Item;
import com.delly.delly.domains.address.Address;
import com.delly.delly.domains.address.AddressRepository;
import com.delly.delly.domains.client.ClientRepository;
import com.delly.delly.domains.company.CompanyRepository;
import com.delly.delly.domains.courier.Courier;
import com.delly.delly.domains.courier.CourierRepository;
import com.delly.delly.domains.district.DistrictRepository;
import com.delly.delly.domains.order.OrderRepository;
import com.delly.delly.domains.order.Orders;
import com.delly.delly.domains.order.controller.mapper.OrderUtils;
import com.delly.delly.domains.order.service.mapper.OrderWithAddress;
import com.delly.delly.exception.exceptions.OrdersNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderService {

    ClientRepository clientRepository;
    CompanyRepository companyRepository;
    OrderRepository orderRepository;
    CourierRepository courierRepository;
    AddressRepository addressRepository;
    DistrictRepository districtRepository;

    public ResponseEntity<String> saveOrder(int ClientID, CompanyOrder companyOrder) {
        float totalPrice = companyOrder.getOrders().getItems().stream().map(Item::getPrice).reduce(0f, Float::sum);
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        companyOrder.getOrders().setCompany(companyRepository.getCompanyByID(companyOrder.getCompanyID()));
        companyOrder.getOrders().setDate(dateFormat.format(date));
        companyOrder.getOrders().setStatus("IN_PROGRESS");
        companyOrder.getOrders().setClient(clientRepository.getClientByID(ClientID));
        companyOrder.getOrders().setTotal_price(totalPrice);

        orderRepository.save(companyOrder.getOrders());

        return new ResponseEntity<>("Order successfully saved", HttpStatus.OK);
    }

    public ResponseEntity<List<OrderWithAddress>> getOrderWithAddress(int deliverID) {

        List<Orders> orders = orderRepository.getOrderByDeliverIDAndStatus(deliverID);
        List<Orders> parcelOrders = orderRepository.getParcelOrdersByDeliverDistrictAndOrderStatus(deliverID);
        List<OrderWithAddress> ordersWithAddress = new LinkedList<>();

        if (orders.size() != 0 || parcelOrders.size() != 0) {
            for (Orders order : orders) {
                Address addressClient = addressRepository.getAddressByClientID(order.getClient().getID());
                Address addressParcel = addressRepository.getAddressByCompanyIDAnAndDistrictID(order.getCompany().getID(), addressClient.getDistrict().getID());
                String courierLocation = courierRepository.getDeliverByID(deliverID).getLocation();
                ordersWithAddress.add(new OrderWithAddress(order, addressClient, addressParcel, courierLocation));
            }
            for(Orders order: parcelOrders){
                Address addressClient = order.getAddress();
                Address addressParcel = addressRepository.getAddressByClientID(order.getClient().getID());
                String courierLocation = courierRepository.getDeliverByID(deliverID).getLocation();
                ordersWithAddress.add(new OrderWithAddress(order, addressClient, addressParcel, courierLocation));
            }

            return new ResponseEntity<>(ordersWithAddress,HttpStatus.OK);
        }
          return  null;
    }

    public ResponseEntity<List<Orders>> getOrdersByClientID(int ID) {
        List<Orders> clientOrders =  orderRepository.findOrdersByClientID(ID).orElseThrow(
                () -> new OrdersNotFoundException("client: " + ID)
        );

        return new ResponseEntity<>(clientOrders, HttpStatus.OK);
    }

    public ResponseEntity<String> updateOrderStatus(Integer orderID, OrderUtils orderUtils) {

        Orders orders = orderRepository.getOrderByID(orderID);

        if(orders.getStatus().equals("IN_PROGRESS")) {
            orders.setReward(orderUtils.getReward());
            orders.setStatus("DELIVERED");
            orders.setCourier(courierRepository.getDeliverByID(orderUtils.getCourierID()));
            orderRepository.save(orders);

            Courier courier = orders.getCourier();
            courier.setDistance(courier.getDistance() + orderUtils.getDistance());
            courier.setCash(courier.getCash() + orderUtils.getReward() + orders.getTip());
            courierRepository.save(courier);
            return new ResponseEntity<>("Order: " + orderID + " has been updated", HttpStatus.OK);
        }

        return new ResponseEntity<>("Order has already been delivered", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Orders>> getOrderByDeliverIDAndStatusDelivered(Integer deliverID) {
        List<Orders> orders =  orderRepository.findOrdersByCourierIDAndStatusEquals(deliverID, "DELIVERED")
                .orElseThrow(() -> new OrdersNotFoundException("courier: " + deliverID));
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    public ResponseEntity<String> saveParcelOrder(Integer clientID, Parcel parcel){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        parcel.getAddress().setDistrict(districtRepository.getDistinctByID(parcel.getDistrictID()));
        addressRepository.save(parcel.getAddress());

        Orders orders = new Orders(
                parcel.getPrice(),
                dateFormat.format(date),
                "IN_PROGRESS",
                clientRepository.getClientByID(clientID),
                null,
                null,
                 parcel.getAddress());

        orderRepository.save(orders);

        return new ResponseEntity<>("Parcel order successfully saved", HttpStatus.OK);
    }
}

