package com.delly.delly.domains.creditcard;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer ID;

    @NotNull
    private String cardNumber;

    @NotNull
    private String CVV;

    @NotNull
    private String expired;

    public CreditCard(String cardNumber, String CVV, String expired) {
        this.cardNumber = cardNumber;
        this.CVV = CVV;
        this.expired = expired;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "ID=" + ID +
                ", cardNumber='" + cardNumber + '\'' +
                ", CVV='" + CVV + '\'' +
                ", expired='" + expired + '\'' +
                '}';
    }
}
