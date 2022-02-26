package com.delly.delly.domains.courier;

import com.delly.delly.domains.district.District;
import com.delly.delly.domains.pack.Pack;
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
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

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
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String location;

    @OneToOne
    @JoinColumn(name = "district_id")
    private District district;

    @OneToMany(mappedBy = "courier")
    private List<Pack> packs;

    public Courier(String firstName, String lastName, String PESEL, Float cash, Integer distance, String phoneNumber,
                   String email, String password, District district, String location, List<Pack> packs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PESEL = PESEL;
        this.cash = cash;
        this.distance = distance;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.district = district;
        this.location = location;
        this.packs = packs;
    }

    @Override
    public String toString() {
        return "Deliver{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", cash=" + cash +
                ", distance=" + distance +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", location='" + location + '\'' +
                ", districtID=" + district.getID() +
                '}';
    }
}
