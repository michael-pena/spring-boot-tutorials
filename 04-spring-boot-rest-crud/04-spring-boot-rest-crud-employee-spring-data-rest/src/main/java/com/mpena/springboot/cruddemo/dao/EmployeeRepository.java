package com.mpena.springboot.cruddemo.dao;

import com.mpena.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Integer> {

}
