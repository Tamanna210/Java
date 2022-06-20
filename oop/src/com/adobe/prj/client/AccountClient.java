package com.adobe.prj.client;

import com.adobe.prj.entity.Account;

public class AccountClient {

	public static void main(String[] args) {
		Account swethaAcc = new Account();
		Account rahulAcc = new Account();
		
		swethaAcc.deposit(5000);// deposit(swethaAcc, 5000);
		rahulAcc.deposit(9500); // deposit(rahulAcc, 9500);
		
		System.out.println("Swetha Acc:");
		System.out.println("Balance :" + swethaAcc.getBalance());
		System.out.println("Acc :" + swethaAcc.getAccNo());
		
		System.out.println("Rahul Acc:");
		System.out.println("Balance :" + rahulAcc.getBalance());
		System.out.println("Acc :" + rahulAcc.getAccNo());
	}

}
