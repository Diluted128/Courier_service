package com.delly.delly.domain.user.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client getClientById(int id);

    Optional<Client> findClientByLogin(String email);

    Optional<Client> findClientByLoginAndPassword(String email, String password);

}
