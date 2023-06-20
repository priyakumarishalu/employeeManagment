package com.example.emp.service;

import com.example.emp.entity.EmployeeEntity;
import com.example.emp.model.Employee;
import com.example.emp.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, entity);
        repository.save(entity);
        return employee;

    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> emp=repository.findAll().stream().map((i)->new Employee(i.getId(),i.getFirstName()
                ,i.getLastName(),i.getEmail())).collect(Collectors.toList());
        return emp;
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        EmployeeEntity entity=repository.findById(id).get();
        if(entity!=null){
            repository.deleteById(id);
            return true;
        }


        return false;
    }

    @Override
    public Employee getEmployeeById(long id) {
       EmployeeEntity entity= repository.findById(id).get();
       Employee employee= new Employee();
       BeanUtils.copyProperties(entity,employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        EmployeeEntity entity=repository.findById(id).get();
        entity.setFirstName(employee.getFirstName());
        entity.setLastName(employee.getLastName());
        entity.setEmail(employee.getEmail());
        repository.save(entity);

        return employee;
    }
}
