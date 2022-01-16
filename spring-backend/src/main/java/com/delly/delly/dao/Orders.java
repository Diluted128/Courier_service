package com.delly.delly.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer ID;

    @NotNull
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="client_id")
    private Client client;

    @Nullable
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "company_id")
    private Company company;

    @NotNull
    private float total_price;

    @NotNull
    private float tip;

    @NotNull
    private String date;

    @NotNull
    private String status;

    @Nullable
    private Float reward;

    @NotNull
    @OneToOne
    @JoinColumn(name = "addresee")
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "orders")
    private List<Pack> packs;

    @ManyToMany
    @JoinTable(
            name = "Order_item",
            joinColumns = { @JoinColumn(name = "order_id")},
            inverseJoinColumns = { @JoinColumn(name = "item_id")}
    )
    private List<Item> items;

    @OneToOne
    @JoinColumn(name = "deliver_id")
    private Deliver deliver;

    public Orders(){}

    public Orders(Float total_price, String date, String status, Client client, Company company, List<Item> items, Address address){
        this.total_price = total_price;
        this.date = date;
        this.status = status;
        this.client = client;
        this.company = company;
        this.items = items;
        this.address = address;
    }

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

    public float getTip() {
        return tip;
    }

    public void setTip(float tip) {
        this.tip = tip;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getReward() {
        return reward;
    }

    public void setReward(Float reward) {
        this.reward = reward;
    }

    public Deliver getDeliver() {
        return deliver;
    }

    public void setDeliver(Deliver deliver) {
        this.deliver = deliver;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
