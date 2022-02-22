package com.delly.delly.domains.client;

import com.delly.delly.domains.address.Address;
import com.delly.delly.domains.creditcard.CreditCard;
import com.delly.delly.domains.order.Orders;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer ID;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Nullable
    private String phoneNumber;

    @NotNull
    private String email;

    @NotNull
    private String password;

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

    public Client(String email, String firstName, String lastName, String password, String phoneNumber, List<Orders> orders, Address address, CreditCard creditCard) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.orders = orders;
        this.creditCard = creditCard;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", creditCardID=" + creditCard.getID() +
                ", addressID=" + address.getID() +
                '}';
    }
}
