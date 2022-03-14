package com.delly.delly.domain.user.courier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourierRepository extends JpaRepository<Courier,Integer> {

    Optional<Courier> findDeliverByLoginAndPassword(String login, String password);

    Courier getDeliverById(int id);

    Optional<Courier> findCourierByLogin(String login);

}
