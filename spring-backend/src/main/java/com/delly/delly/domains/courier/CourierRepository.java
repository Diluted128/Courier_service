package com.delly.delly.domains.courier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourierRepository extends JpaRepository<Courier,Integer> {

    Optional<Courier> findDeliverByEmailAndPassword(String email, String password);

    Courier getDeliverByID(int id);

}
