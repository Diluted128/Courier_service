package com.delly.delly.Service;

import com.delly.delly.dao.Item;
import com.delly.delly.dao.Orders;
import com.delly.delly.repositories.ClientRepository;
import com.delly.delly.repositories.CompanyRepository;
import com.delly.delly.repositories.OrderRepository;
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

    @Autowired
    public OrderService(ClientRepository clientRepository, CompanyRepository companyRepository,
                        OrderRepository orderRepository) {
        this.clientRepository = clientRepository;
        this.companyRepository = companyRepository;
        this.orderRepository = orderRepository;
    }

    public void saveOrder(int ClientID, int CompanyID, Orders orders){
        float totalPrice = orders.getItems().stream().map(Item::getPrice).reduce(0f, Float::sum);
        Date date = new Date();
        DateFormat dateFormat =  new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(dateFormat.format(date) + " " + totalPrice);

        orders.setCompany(companyRepository.getCompanyByCompanyID(CompanyID));
        orders.setDate(dateFormat.format(date));
        orders.setStatus("IN_PROGRESS");
        orders.setClient(clientRepository.getClientsByID(ClientID));

        orderRepository.save(orders);
    }

    public List<Orders> getOrdersByClientID(int ID){
        return orderRepository.getOrdersByClientID(ID);
    }
}
