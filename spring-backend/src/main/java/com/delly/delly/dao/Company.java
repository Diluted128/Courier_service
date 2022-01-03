package com.delly.delly.dao;


import com.fasterxml.jackson.annotation.JsonIgnore;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Orders> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private Set<Department> departments;


    @OneToMany(mappedBy = "company_id")
    private Set<Item> items;

    public Company(){}

    public Company(Integer ID, String name,  String type) {
        this.ID = ID;
        this.name = name;
        this.type = type;
    }

    public Integer ID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}
