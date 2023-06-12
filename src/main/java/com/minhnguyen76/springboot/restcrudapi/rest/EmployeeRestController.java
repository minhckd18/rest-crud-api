package com.minhnguyen76.springboot.restcrudapi.rest;

import com.minhnguyen76.springboot.restcrudapi.entity.Employee;
import com.minhnguyen76.springboot.restcrudapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // inject an EmployeeService
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
       return employeeService.findAll();
    }
}
