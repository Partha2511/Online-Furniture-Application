package com.cg.OFS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.OFS.model.Order;

@Repository
public interface IOrderServiceRepository extends JpaRepository<Order, String>{
	
	
	public Order getOrderByStatus(String status);
	public Order updateOrderById(int orderId);
	
	

}
