package com.delly.delly.domains.officeworker;

import com.delly.delly.domains.address.Address;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OfficeWorker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OfficeWorkerType officeWorkerType;

    @NotNull
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public OfficeWorker(String firstName, String lastName, String PIN, Integer cash, String phoneNumber, String email, OfficeWorkerType officeWorkerType, String password, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PIN = PIN;
        this.cash = cash;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.officeWorkerType = officeWorkerType;
        this.password = password;
        this.address = address;
    }

    @Override
    public String toString() {
        return "OfficeWorker{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", PIN='" + PIN + '\'' +
                ", cash=" + cash +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", officeWorkerType=" + officeWorkerType +
                ", addressID=" + address.getID() +
                '}';
    }
}
