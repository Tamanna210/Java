package com.example.demo.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public class EmployeeDaoFileImpl implements EmployeeDao {

	@Override
	public void addEmployee() {
		System.out.println("file code...");
	}

}

