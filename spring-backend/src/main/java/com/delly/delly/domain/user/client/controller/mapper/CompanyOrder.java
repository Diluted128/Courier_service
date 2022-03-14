package com.delly.delly.domain.user.client.controller.mapper;

import com.delly.delly.domain.order.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyOrder {

    private Orders orders;

    private int CompanyID;
}
