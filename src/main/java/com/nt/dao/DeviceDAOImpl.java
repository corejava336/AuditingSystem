package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dto.Device;

@Repository
public class DeviceDAOImpl implements DeviceDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Device> insert(Device dev, String name, Integer count) {
		try {
			Session session = sessionFactory.getCurrentSession();
			List<Device> devices = searchDeviceByName(name);
			// Check if the device with the given name already exists
			if (devices.isEmpty()) {
				// Create a new Device object with the provided name and count
				Device newDevice = new Device();
				newDevice.setName(name);
				newDevice.setCount(count);
				// Save the new Device object to the database
				session.save(newDevice);
				// Create a new list and add the inserted device
				List<Device> insertedDevices = new ArrayList<>();
				insertedDevices.add(newDevice);
				return insertedDevices;
			} else {
				// If a device with the same name already exists, return the list of existing
				// devices
				return devices;
			}
		} catch (Exception e) {
			throw new DataAccessResourceFailureException("Error occurred while inserting Device", e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Device> searchDeviceByName(String name) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM Device WHERE lower(name) = lower(:name)";
			return session.createQuery(hql, Device.class).setParameter("name", name).getResultList();
		} catch (HibernateException e) {
			throw new DataAccessResourceFailureException("Error occurred while searching for device by name", e);
		}
	}

	@Override
	@Transactional(rollbackFor = DataAccessException.class)
	public List<Device> update(String name, int count) throws DataAccessException {
		List<Device> devices = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			devices = searchDeviceByName(name);
			for (Device device : devices) {
				device.setCount(count);
				session.update(device);
			}
		} catch (DataAccessException e) {
			throw new DataAccessException("Error occurred while updating device", e) {
			};
		}
		return devices;

	}

	@Override
	@Transactional(rollbackFor = DataAccessException.class)
	public void delete(String name) throws DataAccessException {
		try {
			Session session = sessionFactory.getCurrentSession();
			List<Device> devices = searchDeviceByName(name);
			for (Device dev : devices) {
				session.delete(dev);
			}
			System.out.println("Employees with name " + name + " deleted successfully.");
		} catch (DataAccessException e) {
			throw new DataAccessException("Error occurred while deleting employee", e) {
			};
		}
	}
}
