package com.adobe.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.prj.dao.OrderDao;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dto.OrderReport;
import com.adobe.prj.entity.Item;
import com.adobe.prj.entity.Order;
import com.adobe.prj.entity.Product;

@Service
public class OrderService {
	@Autowired
	private ProductDao productDao; // Spring Data JPA generated class for interface is injected
	
	@Autowired
	private OrderDao orderDao;
	
	/* 
	 	REACT / Angular / Vue
	  	{
	  		"customer" : {"email": "sam@adobe.com"},
	  		"items": [
	  			{"product": { "id" : 3}, "qty":3},
	  			{"product": { "id" : 2}, "qty":1}
	  		]
	  	}
	 */
	// Atomic operation
	@Transactional
	public void placeOrder(Order order) {
		List<Item> items = order.getItems();
		double total = 0.0;
		for(Item i : items) {
			Product p = productDao.findById(i.getProduct().getId()).get();
			if(i.getQty() > p.getQuantity()) {
				throw new IllegalArgumentException("product not in stock!!!");
			}
			i.setAmount(p.getPrice() * i.getQty()); // tax , discount
			total += i.getAmount();
			p.setQuantity(p.getQuantity() - i.getQty()); // DIRTY ==> update SQL
		}
		order.setTotal(total);
		orderDao.save(order); // this saves order and items also ==> CASCADE
	}
	
	public List<Order> getOrders() {
		return orderDao.findAll();
	}
	
	public List<Product> getProducts() {
		return productDao.findAll();
	}
	
	public Product addProduct(Product p) {
		return productDao.save(p);
	}
	
	public Product getProductById(int id) {
		return productDao.findById(id).get();
	}
	
	public List<Product> byRange(double low, double high) {
		return productDao.getByRange(low, high);
	}
	
	@Transactional
	public Product updateProduct(double price, int id) {
		productDao.updateProduct(price, id);
		return  getProductById(id);
	}
	
//	public List<Object[]> getReport() {
//		return orderDao.getReport();
//	}
	public List<OrderReport> getReport() {
		return orderDao.getReport();
	}
}
