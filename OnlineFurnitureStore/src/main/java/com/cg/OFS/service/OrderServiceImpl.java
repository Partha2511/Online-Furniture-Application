package com.cg.OFS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.OFS.dao.IOrderServiceRepository;
import com.cg.OFS.model.Order;


@Service
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	IOrderServiceRepository repo;

	@Override
	public List<Order> getAllOrders() {
		List<Order> orders= repo.findAll();
		return orders;
	}

	@Override
	public Order getOrderByStatus(String status) {
		return null;
		
	
	}

	@Override
	public Order updateOrder(Order order) {
		if(repo.existsById(order.getOrderId())) {
			repo.save(order);
		}
		return order;
	}

//	@Override
//	public Order updateOrderById(String orderId) {
//		if(repo.existsById(orderId)) {
//			repo.save(order);
//		}
//		return order;
//	}
	

}
