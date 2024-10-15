package com.nt.dao;

import java.util.List;

import com.nt.dto.Device;

public interface DeviceDao {

	List<Device> insert(Device dev,String name, Integer count);

	List<Device> searchDeviceByName(String name);

	List<Device> update(String name, int count);

	void delete(String name);

}
