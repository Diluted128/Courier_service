package com.delly.delly.domains.item;

import com.delly.delly.domains.company.Company;
import com.delly.delly.domains.order.Orders;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int ID;

    @NotNull
    private String name;

    @Nullable
    private String description;

    @Column(name = "size")
    @Nullable
    private String size;

    @NotNull
    private float price;

    @JsonIgnore
    @ManyToMany(mappedBy = "items")
    private Set<Orders> orders;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "company_id")
    private Company company_id;

    public Item(String name, String description, String size, float price, Set<Orders> orders, Company company_id) {
        this.name = name;
        this.description = description;
        this.size = size;
        this.price = price;
        this.orders = orders;
        this.company_id = company_id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", companyID=" + company_id.getID() +
                '}';
    }
}
