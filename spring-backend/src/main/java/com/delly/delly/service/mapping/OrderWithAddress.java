package com.delly.delly.service.mapping;

import com.delly.delly.domains.address.Address;
import com.delly.delly.domains.order.Orders;

public class OrderWithAddress {

    private Orders orders;

    private Address clientAddress;

    private Address packAddress;

    private String courierLocation;

    public OrderWithAddress(Orders orders, Address clientAddress, Address packAddress, String courierLocation) {
        this.orders = orders;
        this.clientAddress = clientAddress;
        this.packAddress = packAddress;
        this.courierLocation = courierLocation;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Address getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(Address clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Address getPackAddress() {
        return packAddress;
    }

    public void setPackAddress(Address packAddress) {
        this.packAddress = packAddress;
    }

    public String getCourierLocation() {
        return courierLocation;
    }

    public void setCourierLocation(String courierLocation) {
        this.courierLocation = courierLocation;
    }
}
