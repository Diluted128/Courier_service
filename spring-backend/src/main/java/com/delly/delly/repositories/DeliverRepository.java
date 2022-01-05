package com.delly.delly.repositories;

import com.delly.delly.dao.Deliver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliverRepository extends JpaRepository<Deliver,Integer> {

    @Query(value = "SELECT ID FROM DELIVER WHERE EMAIL = ?1 AND PASSWORD = ?2",
            nativeQuery = true)
    Integer getDeliverByEmailAndPassword(String email, String password);

    @Query(value = "SELECT * FROM DELIVER WHERE DISTRICT_ID = ?1", nativeQuery=true)
    List<Deliver> getDeliverByDistrictID(Integer DistrictID);

    @Query(value = "SELECT * FROM DELIVER WHERE ID = ?1", nativeQuery = true)
    Deliver getDeliverByID(Integer ID);

//    @Query(value = "UPDATE DELIVER SET CASH = ?1 WHERE ID = ?2 RETURNING ID")
//    Integer updateDeliversCash(Float cash, Integer deliverID);

}
