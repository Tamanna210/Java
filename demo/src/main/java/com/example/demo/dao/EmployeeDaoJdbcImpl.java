package com.example.demo.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("prod")
public class EmployeeDaoJdbcImpl implements EmployeeDao {

	@Override
	public void addEmployee() {
		System.out.println("added in database!!!");
	}

}
