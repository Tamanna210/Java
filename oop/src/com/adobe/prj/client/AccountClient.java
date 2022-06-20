package com.adobe.prj.client;

import com.adobe.prj.entity.Account;

public class AccountClient {

	public static void main(String[] args) {
		// count is zero
		System.out.println(Account.getCount()); // 0
		Account swethaAcc = new Account();
		System.out.println(Account.getCount()); // 1
		// count is 1
		Account rahulAcc = new Account("SB101", 500);
		// count is 2
		
		swethaAcc.deposit(5000);// deposit(swethaAcc, 5000);
		rahulAcc.deposit(9500); // deposit(rahulAcc, 9500);
		
		System.out.println(Account.getCount()); // 2
		
		System.out.println("Swetha Acc:");
		System.out.println("Balance :" + swethaAcc.getBalance());
		System.out.println("Acc :" + swethaAcc.getAccNo());
//		System.gc(); // request to GC not a demand
		System.out.println("Rahul Acc:");
		System.out.println("Balance :" + rahulAcc.getBalance());
		System.out.println("Acc :" + rahulAcc.getAccNo());
	}

}
