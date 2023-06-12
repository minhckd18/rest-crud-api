package com.minhnguyen76.springboot.restcrudapi.rest;

import com.minhnguyen76.springboot.restcrudapi.entity.Employee;
import com.minhnguyen76.springboot.restcrudapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // retrieve all employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
       return employeeService.findAll();
    }

    // retrieve 1 employee by id
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        return employeeService.findById(employeeId);
    }

    // create a new employee
    @PostMapping("/employees")
    public Employee post(@RequestBody Employee employee) {
        // make sure employeeId equal 0
        // so that database will insert as a new employee
        employee.setId(0);

        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }

    // update an existing employee
    @PutMapping("/employees")
    public Employee put(@RequestBody Employee employee) {
        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }

    // delete an existing employee by Id
    @DeleteMapping("/employees/{employeeId}")
    public String deleteById(@PathVariable int employeeId) {
        employeeService.deleteById(employeeId);
        return "Deleted 1 employee with Id: " + employeeId;
    }
}
