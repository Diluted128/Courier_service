package com.delly.delly.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @NotNull
    private String street;

    @Nullable
    private String localNumber;

    @NotNull
    private String postalCode;

    @Nullable
    private String flatNumber;

    @NotNull
    private String town;

    @Nullable
    @JsonIgnore
    private String location;

    @Nullable
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "distinct_id")
    private District distinct;

    public Address(){}

    public Address(String flatNumber, String localNumber, String location, String postalCode, String street, String town){
        this.street = street;
        this.localNumber = localNumber;
        this.postalCode = postalCode;
        this.flatNumber = flatNumber;
        this.town = town;
        this.location = location;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public District getDistinct() {
        return distinct;
    }

    public void setDistinct(District distinct) {
        this.distinct = distinct;
    }
}
