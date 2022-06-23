package com.adobe.prj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicle {
	@Id
	@Column(name="reg_no", length = 100, nullable = false)
	private String registrationNumber;
	
	private String type;
	
	@Column(name="manufacture_year")
	private int year;

	public Vehicle() {
	}

	public Vehicle(String registrationNumber, String type, int year) {
		this.registrationNumber = registrationNumber;
		this.type = type;
		this.year = year;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}
