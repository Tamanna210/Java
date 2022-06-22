package com.adobe.prj.client;

import com.adobe.prj.dao.DaoException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

public class AddClient {

	public static void main(String[] args) {
		ProductDao productDao = new ProductDaoJdbcImpl();
		
		try {
			 Product p = new Product(0, "Logitech Mouse", 680, 100);
			 productDao.addProduct(p);
			 System.out.println("Product added!!!");
		} catch (DaoException e) {
			e.printStackTrace(); // development state
//			System.out.println(e.getMessage());
		}
	}

}
