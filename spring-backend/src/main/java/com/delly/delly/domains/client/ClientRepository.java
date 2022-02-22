package com.delly.delly.domains.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client getClientByID(int id);

    Optional<Client> findClientByEmail(String email);

    Optional<Client> findClientByEmailAndPassword(String email, String password);

    // change
    @Query(value = "UPDATE CLIENT SET FIRST_NAME = ?2, LAST_NAME = ?3, PHONE_NUMBER = ?4 WHERE ID = ?1", nativeQuery = true)
    Object saveClientsExtendedPersonalData(int ID, String name, String surname, String phoneNumber);

}
