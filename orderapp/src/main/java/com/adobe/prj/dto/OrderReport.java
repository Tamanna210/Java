package com.adobe.prj.dto;

import java.util.Date;

public class OrderReport {
	private String firstName;
	private String lastName;
	private Date orderDate;
	private double total;
	public OrderReport() {
	}
	public OrderReport(String firstName, String lastName, Date orderDate, double total) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.orderDate = orderDate;
		this.total = total;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
