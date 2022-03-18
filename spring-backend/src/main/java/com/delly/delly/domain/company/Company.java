package com.delly.delly.domain.company;

import com.delly.delly.domain.department.Department;
import com.delly.delly.domain.item.Item;
import com.delly.delly.domain.order.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @OneToMany(mappedBy = "company")
    private Set<Department> departments;

    @JsonManagedReference
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
