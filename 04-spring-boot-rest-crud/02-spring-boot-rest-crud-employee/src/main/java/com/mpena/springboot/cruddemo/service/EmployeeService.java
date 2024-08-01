package com.mpena.springboot.cruddemo.service;

import com.mpena.springboot.cruddemo.entity.Employee;

import java.util.List;


public interface EmployeeService {
    List<Employee> findall();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
