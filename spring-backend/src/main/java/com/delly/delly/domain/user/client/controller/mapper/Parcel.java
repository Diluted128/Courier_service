package com.delly.delly.domain.user.client.controller.mapper;

import com.delly.delly.domain.address.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parcel {

    private Address address;

    private Float price;

    private int DistrictID;
}
