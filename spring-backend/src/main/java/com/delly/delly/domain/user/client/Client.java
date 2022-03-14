package com.delly.delly.domain.user.client;

import com.delly.delly.domain.address.Address;
import com.delly.delly.domain.creditcard.CreditCard;
import com.delly.delly.domain.order.Orders;
import com.delly.delly.domain.role.Role;
import com.delly.delly.domain.user.User;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Client extends User {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Nullable
    private String phoneNumber;

    @Nullable
    @OneToMany(mappedBy = "client")
    private List<Orders> orders;

    @Nullable
    @OneToOne
    @JoinColumn(name = "creditCard_id")
    private CreditCard creditCard;

    @Nullable
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Client(String login, String firstName, String lastName, String password, String phoneNumber,
                  List<Orders> orders, Address address, Role role, CreditCard creditCard) {
        super(login, password, role);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.orders = orders;
        this.creditCard = creditCard;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + getLogin() + '\'' +
                ", password='" + getPassword() + '\'' +
                '}';
    }
}
