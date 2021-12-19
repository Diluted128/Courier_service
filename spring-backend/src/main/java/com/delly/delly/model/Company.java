package com.delly.delly.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer ID;

    @NotNull
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CompanyType type;

    @NotNull
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "company")
    private List<Order> orders;

    @ManyToMany
    @JoinTable(
            name = "Company_item",
            joinColumns = { @JoinColumn(name = "company_id")},
            inverseJoinColumns = { @JoinColumn(name = "item_id")}
    )
    private Set<Item> items;

    public Integer getID() {
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

    public CompanyType getType() {
        return type;
    }

    public void setType(CompanyType type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
}
