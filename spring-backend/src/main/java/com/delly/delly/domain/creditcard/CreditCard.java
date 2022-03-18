package com.delly.delly.domain.creditcard;

import com.delly.delly.domain.user.client.Client;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @NotNull
    @Column(name = "card_number")
    private String cardNumber;

    @NotNull
    private String cvv;

    @NotNull
    @Column(name = "expired_date")
    private String expiredDate;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client_id;

    public CreditCard(String cardNumber, String cvv, String expiredDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiredDate = expiredDate;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "ID=" + ID +
                ", cardNumber='" + cardNumber + '\'' +
                ", CVV='" + cvv + '\'' +
                ", expired='" + expiredDate + '\'' +
                '}';
    }
}
