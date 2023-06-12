package com.minhnguyen76.springboot.restcrudapi.service;

import com.minhnguyen76.springboot.restcrudapi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
