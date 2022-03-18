package com.delly.delly.domain.order;

import com.delly.delly.domain.department.Department;
import com.delly.delly.domain.user.courier.Courier;
import com.delly.delly.domain.user.client.Client;
import com.delly.delly.domain.item.Item;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "DB_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @NotNull
    private float price;

    @NotNull
    private float tip;

    @NotNull
    private String date;

    @NotNull
    private String status;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST
    )
    @JoinTable(
            name = "Order_item",
            joinColumns = { @JoinColumn(name = "order_id")},
            inverseJoinColumns = { @JoinColumn(name = "item_id")}
    )
    private Set<Item> items;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name="client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER,
               cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    public Order(Float price, String date, String status, Client client, Department department, Set<Item> items){
        this.price = price;
        this.date = date;
        this.status = status;
        this.client = client;
        this.department = department;
        this.items = items;
    }
}
