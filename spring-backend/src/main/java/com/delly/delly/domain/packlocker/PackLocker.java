package com.delly.delly.domain.packlocker;

import com.delly.delly.domain.address.Address;
import com.delly.delly.domain.pack.Pack;
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
public class PackLocker {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer ID;

    @NotNull
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "packLocker")
    private List<Pack> packs;

    public PackLocker(Address address, List<Pack> packs) {
        this.address = address;
        this.packs = packs;
    }
}
