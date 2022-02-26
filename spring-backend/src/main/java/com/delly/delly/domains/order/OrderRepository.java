package com.delly.delly.domains.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    Orders getOrderByID(int ID);

    Optional<List<Orders>> findOrdersByClientID(int ID);

    Optional<List<Orders>> findOrdersByCourierIDAndStatusEquals(int id, String delivered);

    @Query(value = "SELECT * FROM ORDERS WHERE STATUS = 'IN_PROGRESS' AND ADDRESEE IS NULL AND (SELECT DISTRICT_ID FROM ADDRESS WHERE ADDRESS.ID = " +
            "(SELECT ADDRESS_ID FROM CLIENT WHERE ID = CLIENT_ID)) = (SELECT DISTRICT_ID FROM DELIVER WHERE ID = ?1) AND DELIVER_ID IS NULL", nativeQuery = true)
    List<Orders> getOrderByDeliverIDAndStatus(Integer ID);

    @Query(value = "SELECT * FROM ORDERS WHERE STATUS = 'IN_PROGRESS' AND ADDRESEE IS NOT NULL AND DELIVER_ID IS NULL AND " +
            "(SELECT DISTRICT_ID FROM ADDRESS WHERE ID = ORDERS.ADDRESEE) = (SELECT DISTRICT_ID FROM DELIVER WHERE ID = ?1)", nativeQuery = true)
    List<Orders> getParcelOrdersByDeliverDistrictAndOrderStatus(Integer deliverID);
}
