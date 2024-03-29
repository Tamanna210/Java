package com.adobe.prj.entity;

import com.adobe.prj.utility.IComparable;

public class Book implements IComparable<Book> {
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
	public int compare(Book other) {
		return this.title.compareTo(other.title); // strcmp
	}

}
