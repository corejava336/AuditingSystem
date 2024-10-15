package com.nt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Import Model
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.dto.employee;
import com.nt.service.EmployeeServiceImpl;

@Controller
public class LoginController {
	private final EmployeeServiceImpl employeeService;

	@Autowired
	public LoginController(EmployeeServiceImpl employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping("/login")
	public String login(Model model) { // Add Model as parameter
		// Add the 'login' model attribute to the model
		model.addAttribute("login", new employee());
		return "login";
	}

	@PostMapping("/process")
	public String process(@ModelAttribute("login") employee emp, Model model) {
	    System.out.println("Attempting login for user: " + emp.getName());
	    
	    // Retrieve a single employee
	    employee loggedInUser = employeeService.searchEmployeeByName(emp.getPass(), emp.getName());
	    
	    if (loggedInUser != null) {
	        System.out.println("Login successful for user: " + emp.getName());
	        return "Device"; // Ensure "Device" is the name of your CRUD page
	    } else {
	        System.out.println("Login failed for user: " + emp.getName());
	        model.addAttribute("error", "Invalid username or password."); // Add error message
	        return "login"; // Return to login on failure
	    }
	}


}
