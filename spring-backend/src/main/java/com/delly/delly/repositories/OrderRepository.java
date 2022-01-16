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

    @Query(value = "SELECT * FROM ORDERS WHERE STATUS = 'IN_PROGRESS' AND ADDRESEE IS NULL AND (SELECT DISTRICT_ID FROM ADDRESS WHERE ADDRESS.ID = " +
            "(SELECT ADDRESS_ID FROM CLIENT WHERE ID = CLIENT_ID)) = (SELECT DISTRICT_ID FROM DELIVER WHERE ID = ?1) AND DELIVER_ID IS NULL", nativeQuery = true)
    List<Orders> getOrderByDeliverIDAndStatus(Integer ID);

    @Query(value = "SELECT * FROM ORDERS WHERE STATUS = 'IN_PROGRESS' AND ADDRESEE IS NOT NULL AND DELIVER_ID IS NULL AND " +
            "(SELECT DISTRICT_ID FROM ADDRESS WHERE ID = ORDERS.ADDRESEE) = (SELECT DISTRICT_ID FROM DELIVER WHERE ID = ?1)", nativeQuery = true)
    List<Orders> getParcelOrdersByDeliverDistrictAndOrderStatus(Integer deliverID);

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
