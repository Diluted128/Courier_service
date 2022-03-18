package com.delly.delly.domain.user.courier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourierRepository extends JpaRepository<Courier,Integer> {

    Courier getCourierByUsername(String username);

    Courier getDeliverById(int id);

    Optional<Courier> findCourierByUsername(String username);

}
