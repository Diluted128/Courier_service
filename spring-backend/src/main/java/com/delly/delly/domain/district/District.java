package com.delly.delly.domain.district;

import com.delly.delly.domain.address.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer ID;

    @NotNull
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "district")
    private List<Address> addresses;

    public District(Integer ID, String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "District{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
