package com.delly.delly.domains.client.controller.mapper;

import com.delly.delly.domains.item.Item;
import com.delly.delly.domains.order.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyOrder {

    private Orders orders;

    private int CompanyID;
}
