package com.delly.delly.dao;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Company {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer CompanyID;

    @NotNull
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CompanyType type;

    @OneToMany(mappedBy = "company")
    private List<Order> orders;

    @OneToMany(mappedBy = "company")
    private Set<Department> departments;

    @OneToMany(mappedBy = "company_id")
    private Set<Item> items;

    public Integer getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(Integer ID) {
        this.CompanyID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyType getType() {
        return type;
    }

    public void setType(CompanyType type) {
        this.type = type;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
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
