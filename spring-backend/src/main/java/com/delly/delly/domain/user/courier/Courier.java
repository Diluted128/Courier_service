package com.delly.delly.domain.user.courier;

import com.delly.delly.domain.district.District;
import com.delly.delly.domain.pack.Pack;
import com.delly.delly.domain.role.Role;
import com.delly.delly.domain.user.User;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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
    private String PESEL;

    @NotNull
    private Float cash;

    @NotNull
    private Integer distance;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String location;

    @OneToOne
    @JoinColumn(name = "district_id")
    private District district;

    @OneToMany(mappedBy = "courier")
    private List<Pack> packs;

    public Courier(String firstName, String lastName, String PESEL, Float cash, Integer distance, String phoneNumber,
                   String login, String password, District district, String location, Role role, List<Pack> packs) {
        super(login, password, role);
        this.firstName = firstName;
        this.lastName = lastName;
        this.PESEL = PESEL;
        this.cash = cash;
        this.distance = distance;
        this.phoneNumber = phoneNumber;
        this.district = district;
        this.location = location;
        this.packs = packs;
    }

    @Override
    public String toString() {
        return "Deliver{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", cash=" + cash +
                ", distance=" + distance +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + getLogin() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", location='" + location + '\'' +
                ", districtID=" + district.getID() +
                '}';
    }
}
