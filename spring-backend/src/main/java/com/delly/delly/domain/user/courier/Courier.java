package com.delly.delly.domain.user.courier;

import com.delly.delly.domain.district.District;
import com.delly.delly.domain.order.Order;
import com.delly.delly.domain.role.Role;
import com.delly.delly.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Courier extends User {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String PIN;

    @NotNull
    private Float cash;

    @NotNull
    private Float distance;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String location;

    @JsonIgnore
    @OneToMany(mappedBy = "courier",
               fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    private Set<Order> orders;

    @OneToOne
    @JoinColumn(name = "district_id")
    private District district;

    public Courier(String firstName, String lastName, String PIN, Float cash, Float distance, String phoneNumber,
                   String login, String password, District district, String location, Role role, Set<Order> orders) {
        super(login, password, role);
        this.firstName = firstName;
        this.lastName = lastName;
        this.PIN = PIN;
        this.cash = cash;
        this.distance = distance;
        this.phoneNumber = phoneNumber;
        this.district = district;
        this.location = location;
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Deliver{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", PIN='" + PIN + '\'' +
                ", cash=" + cash +
                ", distance=" + distance +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", location='" + location + '\'' +
                ", districtID=" + district.getID() +
                '}';
    }
}
