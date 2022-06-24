package com.adobe.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adobe.prj.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	// select * from products where qunatity = ?
	List<Product> findByQuantity(int qty);
	
//	@Query(value = "select * from products where price >= :l and price <= :h", nativeQuery = true)
	@Query("from Product where price >= :l and price <= :h")
	List<Product> getByRange(@Param("l") double low, @Param("h") double high);
	
	@Modifying
	@Query("update Product set price = :pr where id = :id")
	void updateProduct(@Param("pr") double price, @Param("id") int id);
}
