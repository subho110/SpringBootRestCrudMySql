package com.SpringBoot.EmployeeHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.EmployeeHub.Model.EmployeeBean;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeBean, Integer> {

}
