package com.adobe.prj.dao;

import com.adobe.prj.entity.Book;

public class BookDaoMongoDbImpl implements BookDao {

	@Override
	public void addBook(Book book) {
		// MongoDB Collections.create // Model.save();
		System.out.println("book stored in MongoDB : " + book.getTitle());
	}

	@Override
	public Book getBook(String title) {
		// db.books.find({title:title})
		return null;
	}

}
