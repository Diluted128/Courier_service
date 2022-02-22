package com.delly.delly.domains.creditcard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {

    @Query(value = "SELECT CREDIT_CARD.EXPIRED, CREDIT_CARD.CVV, CREDIT_CARD.CARD_NUMBER from CLIENT " +
            "JOIN CREDIT_CARD ON (CLIENT.CREDIT_CARD_ID = CREDIT_CARD.ID) WHERE CLIENT.ID = ?1",
    nativeQuery = true)
    CreditCard getCreditCardByClientID(int ID);
}
