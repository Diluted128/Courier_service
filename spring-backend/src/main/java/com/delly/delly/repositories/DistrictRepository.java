package com.delly.delly.repositories;

import com.delly.delly.dao.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {

    @Query(value = "SELECT * FROM DISTRICT WHERE ID = ?1", nativeQuery = true)
    District getDistrictByID(Integer ID);
}
