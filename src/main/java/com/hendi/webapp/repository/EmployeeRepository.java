package com.hendi.webapp.repository;

import com.hendi.webapp.domain.Employee;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	
}
