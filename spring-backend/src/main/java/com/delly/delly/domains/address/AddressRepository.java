package com.delly.delly.domains.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address getAddressByID(int ID);

    // remove
    @Query(value = "SELECT MAX(ID) FROM ADDRESS", nativeQuery = true)
    Integer getMaxID();

    // remove
    @Query(value = "INSERT INTO ADDRESS VALUES(?1,?2,?3,?4,?5,?6,?7,?8) RETURNING ID", nativeQuery = true)
    Integer saveAddress(int ID, String flatNumber, String localNumber, String location, String postalCode, String street, String town, int districtID);

    @Query(value = "SELECT * FROM ADDRESS WHERE ID = (SELECT ADDRESS_ID FROM CLIENT WHERE ID = ?1)", nativeQuery = true)
    Address getAddressByClientID(Integer ID);

    @Query(value = "SELECT * FROM ADDRESS JOIN DEPARTMENT ON (DEPARTMENT.ADDRESS_ID = ADDRESS.ID) WHERE COMPANY_ID = ?1 AND DISTRICT_ID = ?2",
            nativeQuery = true)
    Address getAddressByCompanyIDAnAndDistrictID(Integer CompanyID, Integer DistrictID);

}
