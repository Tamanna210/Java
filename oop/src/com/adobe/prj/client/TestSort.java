package com.adobe.prj.client;

import com.adobe.prj.entity.Book;
import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Tv;
import com.adobe.prj.utility.Utility;

public class TestSort {

	public static void main(String[] args) {
		Product[] products = new Product[5]; // Array of Pointers
		products[0] = new Tv(133, "Sony Bravia", 135000.00, "LED"); // upcasting
		products[1] = new Mobile(453, "MotoG", 12999.00, "4G");
		products[2] = new Tv(634, "Onida Thunder", 3500.00, "CRT");
		products[3] = new Mobile(621, "iPhone XR", 99999.00, "4G");
		products[4] = new Mobile(844, "Oppo", 9999.00, "4G");
		
		Book[] books = new Book[3];
		books[0] = new Book("Hibernate", 890.22);
		books[1] = new Book("Alchemist", 9991.22);
		books[2] = new Book("Building Restful", 2890.22);
		
		Utility.sort(books);
		Utility.sort(products);
		
		for(Book b : books) {
			System.out.println(b.getTitle() + ", " + b.getPrice());
		}
		
		for(Product p : products) {
			System.out.println(p.getName() + ", " + p.getPrice()) ;
		}
	}

}
