package com.delly.delly.repositories.mapping;

import com.delly.delly.dao.Company;
import com.delly.delly.dao.ItemSize;
import com.delly.delly.dao.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.Set;

public class ItemWithCompany {

    private int ID;

    private String name;

    private String description;

    private String size;

    private float price;

    private Integer company_id;

    public ItemWithCompany(int ID, String description, String name, float price, String size, Integer company_id) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.size = size;
        this.price = price;
        this.company_id = company_id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }
}
