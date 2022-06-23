package com.example.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoFileImpl implements EmployeeDao {

	@Override
	public void addEmployee() {
		System.out.println("file code...");
	}

}

