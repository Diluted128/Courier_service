package com.delly.delly.domain.department;

import com.delly.delly.domain.company.Company;
import com.delly.delly.domain.address.Address;
import com.delly.delly.domain.order.Order;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @JsonBackReference
    @NotNull
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @NotNull
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<Order> order;

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
