package com.delly.delly.domains.client.controller.mapper;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    private String street;

    private String localNumber;

    private String postalCode;

    private String flatNumber;

    private String town;

    private String location;

    private int districtID;

}
