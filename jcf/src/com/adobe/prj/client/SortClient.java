package com.adobe.prj.client;

import java.util.Arrays;
import java.util.Comparator;

import com.adobe.prj.entity.Product;

public class SortClient {
	public static void main(String[] args) {
		String[] names = {"Robert De Niro", 
					"Brad Pitt", "Will Smith", 
					"George Clooney", "Scarlett Johansson",
					"Johnny Depp"};
		
		Arrays.sort(names);
		
		for(String name : names) {
			System.out.println(name);
		}
		
		System.out.println("***");
		
		Arrays.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		
		for(String name : names) {
			System.out.println(name);
		}
		
		System.out.println("**************");
		
		Product[] products = new Product[6];
		products[0] = new Product(645, "Hp Laptop", 135000.00, "computer");
		products[1] = new Product(224, "iPhone", 98000.00, "mobile");
		products[2] = new Product(834, "Logitech Mouse", 600.00, "computer");
		products[3] = new Product(5, "Sony Bravia", 125000.00, "tv");
		products[4] = new Product(912, "One Plus", 32000.00, "mobile");
		products[5] = new Product(88, "HP Printer", 19000.00, "computer");
		
		Arrays.sort(products);
		
		for(Product p : products) {
			System.out.println(p); // toString()
		}
		
		System.out.println("*********");
		
//		Arrays.sort(products, (p1, p2) -> (int) (p1.getPrice() - p2.getPrice()));
		Arrays.sort(products, (p1, p2) -> {
			int diff = (int) (p1.getPrice() - p2.getPrice());
			if(diff == 0) {
				diff =  p1.getId() - p2.getId();
			}
			return diff;
		});
		
		for(Product p : products) {
			System.out.println(p); // toString()
		}
		
		System.out.println("*********");
		System.out.println("Sort by Name");
		Arrays.sort(products,(p1,p2) ->  p1.getName().compareTo(p2.getName()));
		for(Product p : products) {
			System.out.println(p); // toString()
		}
	}
}
