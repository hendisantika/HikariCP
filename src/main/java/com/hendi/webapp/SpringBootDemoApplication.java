package com.hendi.webapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import com.hendi.webapp.service.EmployeeServiceInterface;

@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@ComponentScan("com.hendi.webapp")
public class SpringBootDemoApplication {

	@Autowired
	EmployeeServiceInterface employeeServiceInterface;
	
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
   
   
}

