package com.delly.delly.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int ID;

    @NotNull
    private String name;

    @Nullable
    private String description;

    @Column(name = "size")
    @Nullable
    private String size;

    @NotNull
    private float price;

    @JsonIgnore
    @ManyToMany(mappedBy = "items")
    private Set<Orders> orders;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "company_id")
    private Company company_id;

    public Item(){}

    public Item(int ID, String name, String description, String size, float price, Set<Orders> orders, Company company_id) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.size = size;
        this.price = price;
        this.orders = orders;
        this.company_id = company_id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public Company getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Company company_id) {
        this.company_id = company_id;
    }
}
