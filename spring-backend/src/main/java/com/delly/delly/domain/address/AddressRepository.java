package com.delly.delly.domain.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query(value = "SELECT * FROM ADDRESS WHERE ID = (SELECT ADDRESS_ID FROM CLIENT WHERE ID = ?1)", nativeQuery = true)
    Address getAddressByClientID(Integer ID);

    @Query(value = "SELECT * FROM ADDRESS JOIN DEPARTMENT ON (DEPARTMENT.ADDRESS_ID = ADDRESS.ID) WHERE COMPANY_ID = ?1 AND DISTRICT_ID = ?2",
            nativeQuery = true)
    Address getAddressByCompanyIDAnAndDistrictID(Integer CompanyID, Integer DistrictID);

}
