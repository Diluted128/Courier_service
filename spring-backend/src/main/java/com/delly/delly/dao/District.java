package com.delly.delly.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer ID;

    @NotNull
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "district")
    private List<Address> addresses;

    public District(){}

    public District(Integer ID, String name) {
        this.ID = ID;
        this.name = name;
    }

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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
