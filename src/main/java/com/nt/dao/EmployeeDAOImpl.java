package com.nt.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.nt.dto.employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(rollbackFor = DataAccessException.class)
    public void insert(employee emp) throws DataAccessException {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(emp); // Save employee details
        } catch (DataAccessException e) {
            throw new DataAccessException("Error occurred while inserting employee", e) {};
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<employee> searchEmployee(String EMailId, String name) throws DataAccessException {
        try {
            Session session = sessionFactory.getCurrentSession();
            String hql = "FROM employee WHERE name = :name OR EMailId=:EMailId";
            return session.createQuery(hql)
                    .setParameter("name", name)
                    .setParameter("EMailId", EMailId)
                    .list();
        } catch (DataAccessException e) {
            throw new DataAccessException("Error occurred while searching employee by name", e) {};
        }
    }

    @Override
    @Transactional(readOnly = true)
    public employee searchEmployeeByName(String pass, String name) throws DataAccessException {
        try {
            Session session = sessionFactory.getCurrentSession();
            String hql = "FROM employee WHERE name = :name AND pass = :pass";
            List<employee> results = session.createQuery(hql)
                    .setParameter("name", name)
                    .setParameter("pass", pass)
                    .list();
            return results.isEmpty() ? null : results.get(0); // Return the first employee or null
        } catch (DataAccessException e) {
            throw new DataAccessException("Error occurred while searching employee by name", e) {};
        }
    }

}
