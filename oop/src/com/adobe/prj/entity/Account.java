package com.adobe.prj.entity;
 
public class Account {
	//state of object
	private String accNo; // instance variables
	private double balance; // instance variables
	private static int count; // class variables ==> not in heap but class data
	
	// default constructor
	public Account() {
		count++;
		accNo = "NA";
	}
	// parameterized constructor
	public Account(String accNo, double balance) {
		count++;
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
	// class method
	public static int getCount() {
		return count;
	}
}
