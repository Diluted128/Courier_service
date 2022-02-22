package com.delly.delly.domains.company;

import com.delly.delly.domains.department.Department;
import com.delly.delly.domains.item.Item;
import com.delly.delly.domains.order.Orders;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Orders> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private Set<Department> departments;

    @OneToMany(mappedBy = "company_id")
    private Set<Item> items;

    public Company(String name,  String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Company{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
