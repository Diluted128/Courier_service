package com.delly.delly.repositories;

import com.delly.delly.dao.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

     @Query(value = "SELECT MAX(ID) FROM ADDRESS", nativeQuery = true)
    Integer getMaxID();

     @Query(value = "INSERT INTO ADDRESS VALUES(?1,?2,?3,?4,?5,?6,?7,?8) RETURNING ID", nativeQuery = true)
    Integer saveAddress(int ID, String flatNumber, String localNumber, String location, String postalCode, String street, String town, int districtID);

    @Query(value = "SELECT * FROM ADDRESS WHERE ID = (SELECT ADDRESS_ID FROM CLIENT WHERE ID = ?1)", nativeQuery = true)
    Address getAddressByClientID(Integer ID);

    @Query(value = "SELECT * FROM ADRESS WHERE ID = ?1", nativeQuery = true)
    Address getAddressByID(Integer ID);

    @Query(value = "SELECT * FROM ADDRESS JOIN DEPARTMENT ON (DEPARTMENT.ADDRESS_ID = ADDRESS.ID) WHERE COMPANY_ID = ?1 AND DISTRICT_ID = ?2",
            nativeQuery = true)
    Address getAddressByCompanyIDAnAndDistrictID(Integer CompanyID, Integer DistrictID);

//    @Query(value = "UPDATE ADDRESS SET FLAT_NUMBER = ?1 LOCAL_NUMBER = ?2 POSTALCODE = ?3 STREET = ?4 TOWN = ?5 ")
}
