package com.delly.delly.repositories;

import com.delly.delly.dao.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

//    @Query(value = "SELECT * FROM DEPARTMENT WHERE COMPANY_ID = ?1", nativeQuery = true)
//    List<Department> getDepartmentByCompanyID(Integer companyID);
}
