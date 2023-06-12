package com.minhnguyen76.springboot.restcrudapi.dao;

import com.minhnguyen76.springboot.restcrudapi.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    // Read all employees
    List<Employee> findAll();
}
