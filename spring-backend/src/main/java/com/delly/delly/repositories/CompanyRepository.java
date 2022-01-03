package com.delly.delly.repositories;

import com.delly.delly.dao.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query(value = "SELECT * FROM COMPANY WHERE ID = ?1", nativeQuery = true)
    Company getCompanyByCompanyID(Integer CompanyID);
}
