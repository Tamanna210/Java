package com.adobe.prj.entity;

import com.adobe.prj.utility.IComparable;

public abstract class Product implements IComparable {
	private int id;
	private String name;
	private double price;

	public Product() {
	}

	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

//	public boolean isExpensive() {
//		return false;
//	}
	
	public abstract boolean isExpensive(); // pure virtual fn
	
	public int compare(Object other) {
		Product p = (Product) other;
		return (int) (this.price - p.price);
	}
}
