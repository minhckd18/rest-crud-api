package com.minhnguyen76.springboot.restcrudapi.dao;

import com.minhnguyen76.springboot.restcrudapi.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery =
                entityManager.createQuery("from Employee", Employee.class);

        // execute and get employee list
        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {

        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {

        Employee targetEmployee = entityManager.find(Employee.class, id);

        entityManager.remove(targetEmployee);
    }
}
