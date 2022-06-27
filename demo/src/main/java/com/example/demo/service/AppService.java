package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;

@Service
public class AppService {
	@Autowired
	private EmployeeDao empDao;
	
	@Autowired
	private EmailConnection con;
	
	public void doTask() {
		con.sendMessage("Employee added");
		empDao.addEmployee();
	}
}
