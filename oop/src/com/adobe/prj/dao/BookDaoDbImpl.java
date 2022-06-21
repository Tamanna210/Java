package com.adobe.prj.dao;

import com.adobe.prj.entity.Book;

public class BookDaoDbImpl implements BookDao {

	@Override
	public void addBook(Book book) {
		// SQL code
		System.out.println("stored in MySQL : " + book.getTitle() );
	}

	@Override
	public Book getBook(String title) {
		// select 
		return null;
	}

}
