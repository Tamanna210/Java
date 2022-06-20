package com.adobe.prj.entity;
 
public class Account {
	//state of object
	private String accNo; // instance variables
	private double balance; // instance variables
	
	// default constructor
	public Account() {
		accNo = "NA";
	}
	// parameterized constructor
	public Account(String accNo, double balance) {
		this.accNo = accNo;
		this.balance = balance;
	}
	
	public void deposit(double amt) {
		this.balance = amt;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public String getAccNo() {
		return this.accNo;
	}
}
