package com.adobe.prj.dao;

import com.adobe.prj.entity.Book;

public interface BookDao {
	void addBook(Book book);
	Book getBook(String title);
}
