package com.adobe.prj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adobe.prj.entity.Product;
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
		modifyProduct();
	}

	private void modifyProduct() {
		Product p = service.updateProduct(999.99, 4);
		System.out.println(p.getPrice() + "," + p.getName());
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
		Product p = service.getProductById(2);
		System.out.println(p);
	}

	private void listProducts() {
		List<Product> products = service.getProducts();
		for(Product p : products) {
			System.out.println(p);
		}
	}

}
