package com.portal.management.dao;

import com.portal.management.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface employeeDao extends JpaRepository<employee, Integer> {

    List<employee> findByEmployeeId(Integer employeeId);

}
