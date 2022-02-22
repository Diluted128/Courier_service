package com.delly.delly.domains.courier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverRepository extends JpaRepository<Deliver,Integer> {

    Deliver getDeliverByEmailAndPassword(String email, String password);

    Deliver getDeliverByID(int id);

}
