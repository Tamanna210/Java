package com.adobe.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adobe.prj.dto.OrderReport;
import com.adobe.prj.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{
//	@Query("select c.firstName, c.lastName, o.orderDate, o.total from Order o inner join o.customer c")
//	public List<Object[]> getReport();
	
	@Query("select new com.adobe.prj.dto.OrderReport(c.firstName, c.lastName, o.orderDate, o.total) from Order o inner join o.customer c")
	public List<OrderReport> getReport();
}
