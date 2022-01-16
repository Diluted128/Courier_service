package com.delly.delly.dao;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.Date;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer ID;

    @NotNull
    private String cardNumber;

    @NotNull
    private String CVV;

    @NotNull
    private String expired;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }
}
