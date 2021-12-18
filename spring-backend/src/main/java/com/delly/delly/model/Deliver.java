package com.delly.delly.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Deliver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    private String firstName;

    private String lastName;

    private String PESEL;

    private Integer cash;

    private String phoneNumber;

    private String email;

    @OneToMany(mappedBy = "deliver")
    private List<Pack> packs;
}
