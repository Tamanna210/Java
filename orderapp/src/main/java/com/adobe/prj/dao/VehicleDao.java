package com.adobe.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adobe.prj.entity.Vehicle;

public interface VehicleDao extends JpaRepository<Vehicle, String>{
	// select * from vehicles where type = ?
	List<Vehicle> findByType(String type);
	
	// select * from vehicles where type = ? and manufacture_year = ?
	List<Vehicle> findByTypeAndYear(String type, int year);
}
