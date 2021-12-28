package com.delly.delly.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @NotNull
    private String name;

    @Nullable
    private String description;

    @Column(name = "size")
    @Nullable
    @Enumerated(EnumType.STRING)
    private ItemSize size;

    @NotNull
    private float price;

    @JsonIgnore
    @ManyToMany(mappedBy = "items")
    private Set<Order> orders;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company_id;

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

    public ItemSize getSize() {
        return size;
    }

    public void setSize(ItemSize size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Company getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Company company_id) {
        this.company_id = company_id;
    }
}
