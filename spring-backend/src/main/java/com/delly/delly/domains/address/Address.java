package com.delly.delly.domains.address;

import com.delly.delly.domains.district.District;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    public Address(String flatNumber, String localNumber, String postalCode, String street, String town, District district){
        this.street = street;
        this.localNumber = localNumber;
        this.postalCode = postalCode;
        this.flatNumber = flatNumber;
        this.town = town;
        this.district = district;
    }

    @Override
    public String toString() {
        return "Address{" +
                "ID=" + ID +
                ", street='" + street + '\'' +
                ", localNumber='" + localNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", flatNumber='" + flatNumber + '\'' +
                ", town='" + town + '\'' +
                ", location='" + location + '\'' +
                ", districtID=" + district.getID() +
                '}';
    }
}
