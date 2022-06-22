package com.adobe.prj.client;

import com.adobe.prj.entity.Product;

public class EqualsTest {

	public static void main(String[] args) {
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		
		String s3 = new String("Aa");
		String s4 = new String("BB");
		
		System.out.println(s1.hashCode()); // 69609650
		System.out.println(s2.hashCode()); // 69609650
		System.out.println(s3.hashCode()); // 2112
		System.out.println(s4.hashCode()); // 2112
		
		Product p1 = new Product(224, "iPhone", 98000.00, "mobile");
		Product p2 = new Product(224, "iPhone", 98000.00, "mobile");

		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		if(p1.equals(p2)) {
			System.out.println("Same data...");
		}
	}

}
