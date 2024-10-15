package com.nt.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.nt.dto.employee;

public interface EmployeeDAO {
    void insert(employee emp);
    employee searchEmployeeByName(String pass, String name); // Update this method
    List<employee> searchEmployee(String EMailId, String name) throws DataAccessException;
}
