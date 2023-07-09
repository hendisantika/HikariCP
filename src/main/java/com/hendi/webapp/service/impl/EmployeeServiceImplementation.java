package com.hendi.webapp.service.impl;

import com.hendi.webapp.domain.Employee;
import com.hendi.webapp.repository.EmployeeRepository;
import com.hendi.webapp.service.EmployeeServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;


@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeServiceInterface {

    @Autowired
    protected EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public Boolean deleteEmployee(String empId) {
        Optional<Employee> temp = employeeRepository.findById(empId);
        employeeRepository.delete(temp.get());
        return true;
    }

    @Override
    public Employee editEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        Iterable<Employee> itr = employeeRepository.findAll();
        return (Collection<Employee>) itr;
    }

    @Override
    public Optional<Employee> findEmployee(String empId) {
        return employeeRepository.findById(empId);
    }


}
