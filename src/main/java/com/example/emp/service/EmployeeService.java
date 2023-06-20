package com.example.emp.service;

import com.example.emp.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Boolean deleteEmployee(Long id);

    Employee getEmployeeById(long id);

    Employee updateEmployee(long id, Employee employee);
}
