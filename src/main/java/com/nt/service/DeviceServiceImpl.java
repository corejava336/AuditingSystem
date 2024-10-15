package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.DeviceDao;
import com.nt.dto.Device;

@Service
@Transactional

public class DeviceServiceImpl {
	@Autowired
	private DeviceDao DeviceDao;

	public void insert(Device dev, String name, Integer count) {
		DeviceDao.insert(dev, name, count);
	}

	public List<Device> searchDeviceByName(String name) {
		return DeviceDao.searchDeviceByName(name);
	}

	public List<Device> update(String name, int count) {
		
		return DeviceDao.update(name,count);
	}

	public void delete(String name) {
		DeviceDao.delete(name);
	}

}
