package com.hendi.webapp.service;

import com.hendi.webapp.domain.Employee;

import java.util.Collection;
import java.util.Optional;


public interface EmployeeServiceInterface {

	Employee saveEmployee(Employee emp);
	Boolean deleteEmployee(String empId);
	Employee editEmployee(Employee emp);
	Optional<Employee> findEmployee(String empId);
	Collection<Employee> getAllEmployees();
}
