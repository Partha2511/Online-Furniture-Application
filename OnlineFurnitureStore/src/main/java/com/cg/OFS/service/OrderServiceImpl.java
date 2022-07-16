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
	public List<Order> getOrderByStatus(String status) {
		return repo.getOrderByStatus(status);
		
	
	}

	@Override
	public Order updateOrder(Order order) {
		if(repo.existsById(order.getOrderId())) {
			Order o = repo.findById(order.getOrderId()).get();
			order.setCustomers(o.getCustomers());
			order.setFurniture(o.getFurniture());
			
			return repo.save(order);
			
		}
		return null;
	}

	@Override
	public Order updateOrderById(int orderId,Order order) {
		if(repo.existsById(orderId)) {
			Order o = repo.findById(orderId).get();
			order.setCustomers(o.getCustomers());
			order.setFurniture(o.getFurniture());
			
			return repo.save(order);
			
		}
		return null;
	}
	

}
