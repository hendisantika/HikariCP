package com.hendi.webapp.controller;

import com.hendi.webapp.domain.Employee;
import com.hendi.webapp.service.EmployeeServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
public class EmployeeController {

	private final EmployeeServiceInterface employeeServiceInterface;

	public EmployeeController(EmployeeServiceInterface employeeServiceInterface) {
		this.employeeServiceInterface = employeeServiceInterface;
	}

	@GetMapping("/")
	public String savePage(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("allEmployees", employeeServiceInterface.getAllEmployees());
		return "index";
	}
	
	@PostMapping("/employee/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee,
			final RedirectAttributes redirectAttributes) {
		
		if(employeeServiceInterface.saveEmployee(employee)!=null) {
			redirectAttributes.addFlashAttribute("saveEmployee", "success");
		} else {
			redirectAttributes.addFlashAttribute("saveEmployee", "unsuccess");
		}
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/employee/{operation}/{empId}")
	public String editRemoveEmployee(@PathVariable("operation") String operation,
			@PathVariable("empId") String empId, final RedirectAttributes redirectAttributes,
			Model model) {
		if(operation.equals("delete")) {
			if(Boolean.TRUE.equals(employeeServiceInterface.deleteEmployee(empId))) {
				redirectAttributes.addFlashAttribute("deletion", "success");
			} else {
				redirectAttributes.addFlashAttribute("deletion", "unsuccess");
			}
		} else if(operation.equals("edit")){
		  Optional<Employee> editEmployee = employeeServiceInterface.findEmployee(empId);
		  if(editEmployee.isPresent()) {
		       model.addAttribute("editEmployee", editEmployee);
		       return "editPage";
		  } else {
			  redirectAttributes.addFlashAttribute("status","notfound");
		  }
		}
		
		return "redirect:/";
	}
	
	@PostMapping(value = "/employee/update")
	public String updateEmployee(@ModelAttribute("editEmployee") Employee editEmployee,
			final RedirectAttributes redirectAttributes) {
		if(employeeServiceInterface.editEmployee(editEmployee)!=null) {
			redirectAttributes.addFlashAttribute("edit", "success");
		} else {
			redirectAttributes.addFlashAttribute("edit", "unsuccess");
		}
//		return "redirect:/savepage";
		return "redirect:/";
	}
}
