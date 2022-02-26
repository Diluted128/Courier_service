package com.delly.delly.domains.order;

import com.delly.delly.domains.company.Company;
import com.delly.delly.domains.courier.Courier;
import com.delly.delly.domains.address.Address;
import com.delly.delly.domains.client.Client;
import com.delly.delly.domains.item.Item;
import com.delly.delly.domains.pack.Pack;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @NotNull
    private float total_price;

    @NotNull
    private float tip;

    @NotNull
    private String date;

    @NotNull
    private String status;

    @Nullable
    private Float reward;

    @NotNull
    @OneToOne
    @JoinColumn(name = "addresee")
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "orders")
    private List<Pack> packs;

    @ManyToMany
    @JoinTable(
            name = "Order_item",
            joinColumns = { @JoinColumn(name = "order_id")},
            inverseJoinColumns = { @JoinColumn(name = "item_id")}
    )
    private List<Item> items;

    @OneToOne
    @JoinColumn(name = "deliver_id")
    private Courier courier;

    @NotNull
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="client_id")
    private Client client;

    @Nullable
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "company_id")
    private Company company;

    public Orders(Float total_price, String date, String status, Client client, Company company, List<Item> items, Address address){
        this.total_price = total_price;
        this.date = date;
        this.status = status;
        this.client = client;
        this.company = company;
        this.items = items;
        this.address = address;
    }

}
