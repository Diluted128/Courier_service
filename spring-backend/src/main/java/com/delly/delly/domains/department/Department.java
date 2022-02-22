package com.delly.delly.domains.department;

import com.delly.delly.domains.company.Company;
import com.delly.delly.domains.address.Address;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @NotNull
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Department(Company company, Address address) {
        this.company = company;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Department{" +
                "ID=" + ID +
                ", company=" + company +
                ", address=" + address +
                '}';
    }
}
