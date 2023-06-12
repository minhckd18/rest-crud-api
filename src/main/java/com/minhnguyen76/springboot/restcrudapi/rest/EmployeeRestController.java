package com.minhnguyen76.springboot.restcrudapi.rest;

import com.minhnguyen76.springboot.restcrudapi.dao.EmployeeDAO;
import com.minhnguyen76.springboot.restcrudapi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // inject an EmployeeDAO
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
       return  employeeDAO.findAll();
    }
}
