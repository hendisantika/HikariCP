package com.hendi.webapp.service;

import com.hendi.webapp.domain.Employee;
import com.hendi.webapp.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeServiceInterface {

    @Autowired
    protected EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee emp) {
        // TODO Auto-generated method stub
        return employeeRepository.save(emp);
    }

    @Override
    public Boolean deleteEmployee(String empId) {
        // TODO Auto-generated method stub
        Employee temp = employeeRepository.findById(empId).orElseThrow(() -> new EntityNotFoundException("Employee with ID " + empId + " Not found"));
        if (temp == null) {
            employeeRepository.delete(temp);
            return true;
        }
        return false;
    }

    @Override
    public Employee editEmployee(Employee emp) {
        // TODO Auto-generated method stub
        return employeeRepository.save(emp);
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        // TODO Auto-generated method stub
        Iterable<Employee> itr = employeeRepository.findAll();
        return (Collection<Employee>) itr;
    }

    @Override
    public Employee findEmployee(String empId) {
        return employeeRepository.findById(empId).orElseThrow(() -> new EntityNotFoundException("Employee with ID " + empId + " Not found"));
    }


}
