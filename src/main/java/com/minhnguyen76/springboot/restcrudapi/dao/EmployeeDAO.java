package com.minhnguyen76.springboot.restcrudapi.dao;

import com.minhnguyen76.springboot.restcrudapi.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    // Read all employees
    List<Employee> findAll();

    // Read an employee by Id
    Employee findById(int id);

    // Create or Update an employee
    Employee save(Employee employee);

    // Delete an existing employee
    void deleteById(int id);
}
