package com.adobe.prj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adobe.prj.entity.Customer;
import com.adobe.prj.entity.Item;
import com.adobe.prj.entity.Order;
import com.adobe.prj.entity.Product;
import com.adobe.prj.service.NotFoundException;
import com.adobe.prj.service.OrderService;

@SpringBootApplication
public class OrderappApplication implements CommandLineRunner {
	@Autowired
	private OrderService service;
	
	
	public static void main(String[] args) {
		SpringApplication.run(OrderappApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// called as soon as Spring container is created and intialized
//		listProducts();
//		getById();
//		addProductData();
//		filterByPrice();
//		modifyProduct();
		
//		createOrder();
	}

	private void createOrder() {
		Order order = new Order(); // order_date is set, oid is auto_increment
		Customer c = new Customer();
		c.setEmail("sam@adobe.com"); // user logins and this data will be in client app
		
		
		Item i1 = new Item();
		Product p1 = new Product();
		p1.setId(3);
		i1.setProduct(p1);
		i1.setQty(3);

		Item i2 = new Item();
		Product p2 = new Product();
		p2.setId(1);
		i2.setProduct(p2);
		i2.setQty(1);
		
		
		order.setCustomer(c);
		order.getItems().add(i1);
		order.getItems().add(i2);
		
		service.placeOrder(order);
	}

	private void modifyProduct() {
		Product p;
		try {
			p = service.updateProduct(999.99, 4);
			System.out.println(p.getPrice() + "," + p.getName());
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void filterByPrice() {
		List<Product> products = service.byRange(500, 10_000);
		for(Product p : products) {
			System.out.println(p);
		}
	}

	private void addProductData() {
		Product p = new Product(0, "LG AC", 45000.00, 100);
		service.addProduct(p);
	}

	private void getById() {
		Product p;
		try {
			p = service.getProductById(2);
			System.out.println(p);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void listProducts() {
		List<Product> products = service.getProducts();
		for(Product p : products) {
			System.out.println(p);
		}
	}

}
