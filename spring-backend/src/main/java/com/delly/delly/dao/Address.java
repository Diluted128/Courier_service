package com.delly.delly.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    public Address(){}

    public Address(String flatNumber, String localNumber, String postalCode, String street, String town, District district){
        this.street = street;
        this.localNumber = localNumber;
        this.postalCode = postalCode;
        this.flatNumber = flatNumber;
        this.town = town;
        this.district = district;
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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
