package com.hendi.webapp.service;

import com.hendi.webapp.domain.Employee;
import java.util.Collection;


public interface EmployeeServiceInterface {

	public Employee saveEmployee(Employee emp);
	public Boolean deleteEmployee(Long empId);
	public Employee editEmployee(Employee emp);
	public Employee findEmployee(Long empId);
	public Collection<Employee> getAllEmployees();
}
