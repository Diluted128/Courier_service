package com.delly.delly.repositories;

import com.delly.delly.dao.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query(value = "SELECT ID FROM CLIENT WHERE EMAIL = ?1",
            nativeQuery = true)
    Integer getClientsByEmail(String email);

    @Query(value = "SELECT ID FROM CLIENT WHERE EMAIL = ?1 AND PASSWORD = ?2",
    nativeQuery = true)
    Integer getClientByEmailAndPassword(String email, String password);

}
