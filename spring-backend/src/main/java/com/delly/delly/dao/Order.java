package com.delly.delly.dao;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @NotNull
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    @Nullable
    @OneToOne
    @JoinColumn(name = "recipient_address")
    private Address recipient;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @NotNull
    private float total_price;

    @NotNull
    private LocalDateTime date;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @OneToMany(mappedBy = "order")
    private List<Pack> packs;

    @OneToOne
    @JoinColumn(name = "order_type_id")
    private OrderType orderType;

    @ManyToMany
    @JoinTable(
            name = "Order_item",
            joinColumns = { @JoinColumn(name = "order_id")},
            inverseJoinColumns = { @JoinColumn(name = "item_id")}
    )
    private Set<Item> items;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Address getRecipient() {
        return recipient;
    }

    public void setRecipient(Address recipient) {
        this.recipient = recipient;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pack> getPacks() {
        return packs;
    }

    public void setPacks(List<Pack> packs) {
        this.packs = packs;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }
}
