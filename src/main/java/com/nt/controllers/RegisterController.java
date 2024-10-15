package com.nt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.nt.dto.employee;
import com.nt.service.EmployeeServiceImpl;

@Controller
public class RegisterController {
    private final EmployeeServiceImpl employeeService;

    @Autowired
    public RegisterController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    } 

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("register", new employee()); // Initialize employee object
        return "register";
    }

    @PostMapping("/Reprocess")
    public String registerSubmit(@ModelAttribute("register") employee emp, RedirectAttributes redirectAttributes) {
        try {
            // Save employee data to the database
            employeeService.insert(emp); // Save employee details

            // Generate OTP
            int otp = employeeService.generateOTP();
            // Send OTP via email
            employeeService.sendEmail(emp.getEMailId(), "OTP Verification", "Your OTP is: " + otp);
            // Store OTP in the map temporarily
            employeeService.storeOTP(emp.getEMailId(), otp);
            // Forward to OTP verification page
            redirectAttributes.addAttribute("EMailId", emp.getEMailId());
            return "redirect:/verifyOTP";
        } catch (Exception e) {
            e.printStackTrace(); // You can replace this with a logger
            redirectAttributes.addFlashAttribute("error", "Registration failed. Please try again.");
            return "redirect:/register"; // Redirect back to registration
        }
    }

    @GetMapping("/verifyOTP")
    public String showVerifyOTPPage(@RequestParam("EMailId") String EMailId, Model model) {
        model.addAttribute("EMailId", EMailId);
        return "verifyOTP";
    }

    @PostMapping("/verifyOTP")
    public String verify(@RequestParam String otp, @RequestParam String EMailId, RedirectAttributes redirectAttributes) {
        if (employeeService.verifyOTP(EMailId, Integer.parseInt(otp))) {
            return "redirect:/login"; // Redirect to login page
        } else {
            return "redirect:/";
        }
    }
}
