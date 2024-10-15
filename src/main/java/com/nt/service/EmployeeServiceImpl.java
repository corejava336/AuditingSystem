package com.nt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.EmployeeDAO;
import com.nt.dto.employee;

@Service
@Transactional
public class EmployeeServiceImpl {

    @Autowired
    private JavaMailSender javaMailSender;

    // This map will temporarily store OTPs with email as the key
    private Map<String, Integer> otpMap = new HashMap<>();

    @Autowired 
    private EmployeeDAO employeeDAO;

    public void insert(employee emp) {
        employeeDAO.insert(emp);
    }

    // Add the new method to search for an employee by name and password
    public employee searchEmployeeByName(String pass, String name) {
        return employeeDAO.searchEmployeeByName(pass, name); // Forward to DAO method
    }

    public List<employee> searchEmployee(String EMailId, String name) {
        return employeeDAO.searchEmployee(EMailId, name);
    }

    public boolean verifyOTP(String email, int otp) {
        Integer storedOTP = otpMap.get(email);
        if (storedOTP != null && storedOTP == otp) {
            // If OTP matches, remove it from the map
            otpMap.remove(email);
            return true;
        }
        return false;
    }

    // Method to generate a 6-digit random OTP
    public int generateOTP() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }

    // Method to send email
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    // Method to store OTP in the map
    public void storeOTP(String email, int otp) {
        otpMap.put(email, otp);
    }
}
