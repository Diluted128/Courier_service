package com.delly.delly.domain.district;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {

    District getDistinctByID(int id);

    Optional<District> findDistinctByName(String name);

}
