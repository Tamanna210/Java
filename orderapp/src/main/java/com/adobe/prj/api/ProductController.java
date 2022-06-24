package com.adobe.prj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private OrderService service;
	
	// GET http://localhost:8080/api/products
	// GET http://localhost:8080/api/products?low=500&high=5000
	@GetMapping()
	public @ResponseBody List<Product> getProducts(
			@RequestParam(name="low", defaultValue = "0.0") double low,
			@RequestParam(name="high", defaultValue = "0.0") double high) {
		if(low == 0.0 && high == 0.0) {
			return service.getProducts();
		} else {
			return service.byRange(low, high);
		}
	}
	
	// GET http://localhost:8080/api/products/4
	@GetMapping("/{id}")
	public @ResponseBody Product getProduct(@PathVariable("id") int id) {
		return service.getProductById(id);
	}
	// POST http://localhost:8080/api/products
	/* 
	    accept: application/json
	 	content-type: application/json
	 	Body:
	 	{
	 		"name": "a",
	 		"price": 100 
	 	}	
	  
	 */
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody Product addProduct(@RequestBody Product p) {
		return service.addProduct(p);
	}
	
	// PUT http://localhost:8080/api/products/3
		/* 
		    accept: application/json
		 	content-type: application/json
		 	Body:
		 	{
		 		"price": 100 
		 	}	
		  
		 */
	@PutMapping("/{id}")
	public @ResponseBody Product updateProduct(@PathVariable("id") int id, @RequestBody Product p) {
		service.updateProduct(p.getPrice(), id);
		return service.getProductById(id);
	}
}
