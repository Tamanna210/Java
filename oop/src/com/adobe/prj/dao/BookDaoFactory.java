package com.adobe.prj.dao;

import java.util.ResourceBundle;

public class BookDaoFactory {
	private static String DAO = "";

	static {
		ResourceBundle res = ResourceBundle.getBundle("config");
		DAO = res.getString("BOOK_DAO").trim();
	}

	public static BookDao getBookDao() {
//		return new BookDaoMongoDbImpl();
		try {
			return (BookDao) Class.forName(DAO).newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
