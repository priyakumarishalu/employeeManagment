package com.example.emp.controller;

import com.example.emp.model.Employee;
import com.example.emp.service.EmployeeService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return service.createEmployee(employee);

    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return service.getAllEmployee();
    }

    @DeleteMapping("/employees/{id}")
    public Map<String,Boolean> deleteEmployee(@PathVariable Long id){
        Boolean b=service.deleteEmployee(id);
        Map<String,Boolean> hs = new HashMap<>();
        hs.put("deleted",b);
        return hs;
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable long id){
        return service.getEmployeeById(id);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable long id,@RequestBody Employee employee){
        return service.updateEmployee(id,employee);
    }

}
