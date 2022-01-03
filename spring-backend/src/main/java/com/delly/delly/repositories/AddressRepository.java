package com.delly.delly.repositories;

import com.delly.delly.dao.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

     @Query(value = "SELECT MAX(ID) FROM ADDRESS", nativeQuery = true)
    Integer getMaxID();

     @Query(value = "INSERT INTO ADDRESS VALUES(?1,?2,?3,?4,?5,?6,?7) RETURNING ID", nativeQuery = true)
    Integer saveAddress(int ID, String flatNumber, String localNumber, String location, String postalCode, String street, String town, int districtID);
}
