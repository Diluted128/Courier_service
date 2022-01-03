package com.delly.delly.repositories;

import com.delly.delly.dao.Deliver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverRepository extends JpaRepository<Deliver,Integer> {

    @Query(value = "SELECT ID FROM DELIVER WHERE EMAIL = ?1 AND PASSWORD = ?2",
            nativeQuery = true)
    Integer getDeliverByEmailAndPassword(String email, String password);
}
