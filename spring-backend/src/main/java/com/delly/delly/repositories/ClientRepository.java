package com.delly.delly.repositories;

import com.delly.delly.dao.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query(value = "SELECT ID FROM CLIENT WHERE EMAIL = ?1",
            nativeQuery = true)
    Integer getClientsByEmail(String email);

    @Query(value = "SELECT ID FROM CLIENT WHERE EMAIL = ?1 AND PASSWORD = ?2",
    nativeQuery = true)
    Integer getClientByEmailAndPassword(String email, String password);

    @Query(value = "SELECT * FROM CLIENT WHERE ID = ?1", nativeQuery = true)
    Client getClientsByID(int id);

    @Query(value = "UPDATE CLIENT SET FIRST_NAME = ?2, LAST_NAME = ?3, PHONE_NUMBER = ?4 WHERE ID = ?1", nativeQuery = true)
    Object saveClientsExtendedPersonalData(int ID, String name, String surname, String phoneNumber);

    @Query(value = "SELECT ADDRESS.DISTRICT_ID FROM ADDRESS WHERE ADDRESS.ID = (SELECT ADDRESS_ID FROM CLIENT WHERE ID = ?1)", nativeQuery = true)
    Integer getDistrictIDByClientID(Integer ID);

}
