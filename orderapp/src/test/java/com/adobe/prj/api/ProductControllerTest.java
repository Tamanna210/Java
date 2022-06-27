package com.adobe.prj.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	@MockBean
	private OrderService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	// GET http://localhost:8080/api/products
	@Test
	public void getProductsTest() throws Exception {
		List<Product> prods = new ArrayList<>();
		prods.add(new Product(1,"a", 500.22, 100));
		prods.add(new Product(2,"b", 2400.00, 100));
		
		// mocking
		when(service.getProducts()).thenReturn(prods); 
		
//		when(service.byRange(0,0)).thenReturn(prods); 
		
		mockMvc.perform(get("/api/products"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(2)))
			.andExpect(jsonPath("$[0].id", is(1)))
			.andExpect(jsonPath("$[1].id", is(2)))
			.andExpect(jsonPath("$[0].name", is("a")));
		
		verify(service, times(1)).getProducts();
	}
}
