package com.delly.delly.domain.user.officeworker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficeWorkerRepository extends JpaRepository<OfficeWorker, Integer> {

    Optional<OfficeWorker> findOfficeWorkerByUsername(String login);
}
