package com.delly.delly.domain.user.client;

import com.delly.delly.domain.address.Address;
import com.delly.delly.domain.creditcard.CreditCard;
import com.delly.delly.domain.order.Order;
import com.delly.delly.domain.role.Role;
import com.delly.delly.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CLIENT")
public class Client extends User {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Nullable
    private String phoneNumber;

    @Nullable
    @JsonIgnore
    @OneToMany(
            mappedBy = "client",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private Set<Order> orders;

    @JsonManagedReference
    @Nullable
    @OneToMany(
            mappedBy = "client_id",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<CreditCard> creditCards;

    @Nullable
    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )

    @JoinColumn(name = "address_id")
    private Address address;

    public Client(String login, String firstName, String lastName, String password, String phoneNumber,
                  Set<Order> orders, Address address, Role role, Set<CreditCard> creditCard) {
        super(login, password, role);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.orders = orders;
        this.creditCards = creditCard;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                '}';
    }
}
