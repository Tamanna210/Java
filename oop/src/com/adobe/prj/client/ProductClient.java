package com.adobe.prj.client;

import java.lang.reflect.Method;

import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Tv;

public class ProductClient {

	public static void main(String[] args) {
		Product[] products = new Product[5]; // Array of Pointers
		products[0] = new Tv(133, "Sony Bravia", 135000.00, "LED"); // upcasting
		products[1] = new Mobile(453, "MotoG", 12999.00, "4G");
		products[2] = new Tv(634, "Onida Thunder", 3500.00, "CRT");
		products[3] = new Mobile(621, "iPhone XR", 99999.00, "4G");
		products[4] = new Mobile(844, "Oppo", 9999.00, "4G");

		printExpensive(products);
//		printDetails(products);
		printDetailsOCP(products);
	}

	// OCP way?
	private static void printDetailsOCP(Product[] products) {
		for(Product p : products) {
			Method[] methods =  p.getClass().getMethods();
			for(Method m : methods) {
				if(m.getName().startsWith("get")) {
					System.out.print(m.getName().substring(3).toUpperCase()); // ID, PRICE, NAME
					System.out.print(" : ");
					try {
						Object ret  = m.invoke(p); // p.getId();
						System.out.println(ret);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
			System.out.println("*****");
		}
	}

	// is this OCP?
	private static void printDetails(Product[] products) {
		for (int i = 0; i < products.length; i++) {
			System.out.println(products[i].getId() + ", " + products[i].getName() + ", " + products[i].getPrice());
			if (products[i] instanceof Tv) { // typechecking
				Tv tv = (Tv) products[i]; // downcasting
				System.out.println(tv.getScreenType());
			} else if (products[i].getClass() == Mobile.class) { // strict typechecking
				Mobile m = (Mobile) products[i];
				System.out.println(m.getConnectivity());
			}
			System.out.println("******************");
		}
	}

	// OCP
	private static void printExpensive(Product[] products) {
		for (int i = 0; i < products.length; i++) {
			if (products[i].isExpensive()) {
				System.out.println(products[i].getName() + " is expensive");
			} else {
				System.out.println(products[i].getName() + " is not  expensive");
			}
		}
	}

}
