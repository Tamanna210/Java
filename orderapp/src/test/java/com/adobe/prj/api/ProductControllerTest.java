package com.adobe.prj.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasItem;
import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	@MockBean
	private OrderService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	// GET http://localhost:8080/api/products?low=500&high=5000
	// GET http://localhost:8080/api/products
	@Test
	public void getProductsTest() throws Exception {
		List<Product> prods = new ArrayList<>();
		prods.add(new Product(1,"a", 500.22, 100));
		prods.add(new Product(2,"b", 2400.00, 100));
		
		// mocking
		when(service.getProducts()).thenReturn(prods); 
		
//		when(service.byRange(500,50000)).thenReturn(prods); 
		
		mockMvc.perform(get("/api/products"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(2)))
			.andExpect(jsonPath("$[0].id", is(1)))
			.andExpect(jsonPath("$[1].id", is(2)))
			.andExpect(jsonPath("$[0].name", is("a")));
		
		verify(service, times(1)).getProducts();
	}
	
	@Test
	public void addProductTest() throws Exception  {
		Product p = new Product(0,"some product", 5666.22, 100);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(p);
		
		when(service.addProduct(Mockito.any(Product.class)))
		.thenReturn(Mockito.any(Product.class));
		
		mockMvc.perform(post("/api/products")
		.content(json)
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated());
		
		verify(service, times(1)).addProduct(Mockito.any(Product.class));
	 
	}
	
	@Test
	public void addProductExceptionTest() throws Exception  {
		Product p = new Product(0, "",  -1500.0, 100);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(p);
		
//		when(service.addProduct(Mockito.any(Product.class)))
//		.thenReturn(Mockito.any(Product.class));
//		
		mockMvc.perform(post("/api/products")
		.content(json)
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.errors", hasSize(2)))
		.andExpect(jsonPath("$.errors", hasItem("Name is required")))
		.andExpect(jsonPath("$.errors", hasItem("Price -1500.0 should be more than 10")));
		
		verifyNoInteractions(service);
	}
}
