package com.delly.delly.repositories;

import com.delly.delly.dao.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    @Query(value = "SELECT * FROM ORDERS WHERE CLIENT_ID = ?1", nativeQuery = true)
    List<Orders> getOrdersByClientID(int ID);
}
