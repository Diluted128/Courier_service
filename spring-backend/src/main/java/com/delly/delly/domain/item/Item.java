package com.delly.delly.domain.item;

import com.delly.delly.domain.company.Company;
import com.delly.delly.domain.order.Order;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Set<Order> order;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company_id;

    public Item(String name, String description, String size, float price, Set<Order> order, Company company_id) {
        this.name = name;
        this.description = description;
        this.size = size;
        this.price = price;
        this.order = order;
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
