package com.adobe.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adobe.prj.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	// select * from products where qunatity = ?
	List<Product> findByQuantity(int qty);
	
	@Query(value = "select * from products where price >= :l and price <= :h", nativeQuery = true)
	List<Product> getByRange(@Param("l") double low, @Param("h") double high);
}
