package com.delly.delly.domains.order;

import com.delly.delly.domains.item.Item;
import com.delly.delly.domains.address.Address;
import com.delly.delly.domains.address.AddressRepository;
import com.delly.delly.domains.client.ClientRepository;
import com.delly.delly.domains.company.CompanyRepository;
import com.delly.delly.domains.courier.Deliver;
import com.delly.delly.domains.courier.DeliverRepository;
import com.delly.delly.domains.department.DepartmentRepository;
import com.delly.delly.domains.district.DistrictRepository;
import com.delly.delly.service.mapping.OrderWithAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    DeliverRepository deliverRepository;
    AddressRepository addressRepository;
    DistrictRepository districtRepository;

    public void saveOrder(int ClientID, int CompanyID, Orders orders) {
        float totalPrice = orders.getItems().stream().map(Item::getPrice).reduce(0f, Float::sum);
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(dateFormat.format(date) + " " + totalPrice);

        orders.setCompany(companyRepository.getCompanyByID(CompanyID));
        orders.setDate(dateFormat.format(date));
        orders.setStatus("IN_PROGRESS");
        orders.setClient(clientRepository.getClientByID(ClientID));

        orderRepository.save(orders);
    }

    public List<OrderWithAddress> getOrderWithAddress(int deliverID) {
        List<Orders> orders = orderRepository.getOrderByDeliverIDAndStatus(deliverID);
        List<Orders> parcelOrders = orderRepository.getParcelOrdersByDeliverDistrictAndOrderStatus(deliverID);
        List<OrderWithAddress> ordersWithAddress = new LinkedList<>();
        System.out.println(orders.size());
        System.out.println(parcelOrders.size());
        if (orders.size() != 0 || parcelOrders.size() != 0) {
            for (Orders order : orders) {
                Address addressClient = addressRepository.getAddressByClientID(order.getClient().getID());
                Address addressParcel = addressRepository.getAddressByCompanyIDAnAndDistrictID(order.getCompany().getID(), addressClient.getDistrict().getID());
                String courierLocation = deliverRepository.getDeliverByID(deliverID).getLocation();
                ordersWithAddress.add(new OrderWithAddress(order, addressClient, addressParcel, courierLocation));
            }
            for(Orders order: parcelOrders){
                Address addressClient = order.getAddress();
                Address addressParcel = addressRepository.getAddressByClientID(order.getClient().getID());
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

        Orders orders = orderRepository.getOrderByID(orderID);

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

    public void saveParcelOrder(Address address, Integer districtID, Integer clientID, float price){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        System.out.println(addressRepository.getMaxID());
        address.setID(addressRepository.getMaxID() + 1);
        address.setDistrict(districtRepository.getDistinctByID(districtID));
        addressRepository.saveAddress(address.getID(), address.getFlatNumber(),
                address.getLocalNumber(), address.getLocation(), address.getPostalCode(), address.getStreet(), address.getTown(), address.getDistrict().getID());

        Orders orders = new Orders(
                price,
                dateFormat.format(date),
                "IN_PROGRESS",
                clientRepository.getClientByID(clientID),
                null,
                null,
                 address);

        orderRepository.save(orders);
    }
}

