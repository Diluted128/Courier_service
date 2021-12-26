package com.delly.delly.dao;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class OfficeWorker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String PIN;

    @NotNull
    private Integer cash;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OfficeWorkerType officeWorkerType;

    @NotNull
    private String password;

    @NotNull
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public OfficeWorkerType getOfficeWorkerType() {
        return officeWorkerType;
    }

    public void setOfficeWorkerType(OfficeWorkerType officeWorkerType) {
        this.officeWorkerType = officeWorkerType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
