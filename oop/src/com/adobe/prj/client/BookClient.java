package com.adobe.prj.client;

import com.adobe.prj.dao.BookDao;
import com.adobe.prj.dao.BookDaoFactory;
import com.adobe.prj.entity.Book;

public class BookClient {

	public static void main(String[] args) {
		Book book = new Book("Restful services", 670.11);
//		BookDao bookDao = new BookDaoDbImpl(); // only place where code changes to switch between strategies
		BookDao bookDao = BookDaoFactory.getBookDao(); // Factory Pattern
		bookDao.addBook(book);
	}

}
