package com.delly.delly.domain.order.service;

import com.delly.delly.domain.user.client.controller.mapper.CompanyOrder;
import com.delly.delly.domain.user.client.controller.mapper.Parcel;
import com.delly.delly.domain.order.Orders;
import com.delly.delly.domain.order.controller.mapper.OrderUtils;
import com.delly.delly.domain.order.service.mapper.OrderWithAddress;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderServiceInt {
    ResponseEntity<String> saveOrder(int ClientID, CompanyOrder companyOrder);
    ResponseEntity<List<OrderWithAddress>> getOrderWithAddress(int deliverID);
    ResponseEntity<List<Orders>> getOrdersByClientID(int ID);
    ResponseEntity<String> updateOrderStatus(Integer orderID, OrderUtils orderUtils);
    ResponseEntity<List<Orders>> getOrderByDeliverIDAndStatusDelivered(Integer deliverID);
    ResponseEntity<String> saveParcelOrder(Integer clientID, Parcel parcel);
}
