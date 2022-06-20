package com.adobe.prj.entity;

import com.adobe.prj.utility.IComparable;

public class Book implements IComparable {
	private String title;
	private double price;
	
	public Book() {
	}

	public Book(String title, double price) {
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int compare(Object other) {
		Book b = (Book) other;
		return this.title.compareTo(b.title); // strcmp
	}

}
