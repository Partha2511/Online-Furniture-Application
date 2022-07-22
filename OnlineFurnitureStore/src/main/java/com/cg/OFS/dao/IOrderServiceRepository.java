package com.cg.OFS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.OFS.model.Order;

@Repository
public interface IOrderServiceRepository extends JpaRepository<Order, Integer>{
	
	
	public List<Order> getOrderByStatus(String status);
	
	public Order getOrderByOrderId(int orderId); 
	
	@Query("select o from Order o join o.customers c where c.uid =?1")
	public List<Order> getOrderByCustomer(int custId);
	
	

}
