package com.hendi.webapp.service;

import com.hendi.webapp.domain.Employee;
import com.hendi.webapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;


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
        Optional<Employee> temp = employeeRepository.findById(empId);
        if (temp.isPresent()) {
            employeeRepository.delete(temp.get());
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
        return employeeRepository.findById(empId).orElseThrow(null);
    }


}
