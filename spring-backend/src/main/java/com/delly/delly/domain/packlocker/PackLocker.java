package com.delly.delly.domain.packlocker;

import com.delly.delly.domain.address.Address;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PackLocker {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer ID;

    @NotNull
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public PackLocker(Address address) {
        this.address = address;
    }
}
