package com.delly.delly.repositories;

import com.delly.delly.dao.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Order;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    @Query(value = "SELECT * FROM ORDERS WHERE CLIENT_ID = ?1", nativeQuery = true)
    List<Orders> getOrdersByClientID(int ID);

    @Query(value = "SELECT * FROM ORDERS WHERE DELIVER_ID = ?1 AND STATUS = 'IN_PROGRESS'", nativeQuery = true)
    Orders getOrderByDeliverIDAndStatus(Integer ID);

    @Query(value = "UPDATE ORDERS SET STATUS = 'DELIVERED' WHERE ID = ?1 RETURNING ID", nativeQuery = true)
    Integer updateOrderStatus(Integer ID);

    @Query(value = "SELECT * FROM ORDERS WHERE ID = ?1", nativeQuery = true)
    Orders getOrderByDeliverID(Integer ID);

    @Query(value = "SELECT COUNT(*) FROM ORDERS WHERE ID = ?1", nativeQuery = true)
    Integer getQuantityOfOrdersByDeliver(Integer ID);

    @Query(value = "SELECT * FROM ORDERS WHERE ID = ?1", nativeQuery = true)
    Orders getOrdersByID(Integer ID);

    @Query(value = "SELECT * FROM ORDERS WHERE DELIVER_ID = ?1 AND STATUS = 'DELIVERED'", nativeQuery = true)
    List<Orders> getOrderByDeliverIDAndStatusDelivered(Integer deliverID);

}
