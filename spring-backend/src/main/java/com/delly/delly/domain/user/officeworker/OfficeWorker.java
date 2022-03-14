package com.delly.delly.domain.user.officeworker;

import com.delly.delly.domain.address.Address;
import com.delly.delly.domain.role.Role;
import com.delly.delly.domain.user.User;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OfficeWorker extends User {

    @NotNull
    private String PIN;

    @NotNull
    private Integer cash;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OfficeWorkerType officeWorkerType;

    @NotNull
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public OfficeWorker(String firstName, String lastName, String PIN, Integer cash, String phoneNumber, String login,
                        OfficeWorkerType officeWorkerType, String password, Address address, Role role) {
        super(login, password, role);
        this.firstName = firstName;
        this.lastName = lastName;
        this.PIN = PIN;
        this.cash = cash;
        this.phoneNumber = phoneNumber;
        this.officeWorkerType = officeWorkerType;
        this.address = address;

    }

    @Override
    public String toString() {
        return "OfficeWorker{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", PIN='" + PIN + '\'' +
                ", cash=" + cash +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + getLogin() + '\'' +
                ", password='" + getPassword()+ '\'' +
                ", officeWorkerType=" + officeWorkerType +
                ", addressID=" + address.getID() +
                '}';
    }
}
