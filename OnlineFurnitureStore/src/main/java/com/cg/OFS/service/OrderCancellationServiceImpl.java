package com.cg.OFS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.OFS.dao.IOrderServiceRepository;
import com.cg.OFS.model.Order;
@Service
public class OrderCancellationServiceImpl implements IOrderCancellationService{
	
	
	@Autowired
	private IOrderServiceRepository repo;

	@Override
	public Integer deleteOrder(Order order) {
		Order delOrder = repo.findById(order.getOrderId()).get();
		if(delOrder==null) {
			return null;
		}
		delOrder.setCustomers(null);
		repo.save(delOrder);
		repo.delete(order);
		return delOrder.getOrderId();
	}

	@Override
	public Integer deleteOrderById(Integer orderId) {
		Order delOrder = repo.findById(orderId).get();
		
		if(delOrder==null) {
			
			return null;
		}
		delOrder.setCustomers(null);
		repo.save(delOrder);
		repo.deleteById(orderId);
		return delOrder.getOrderId();
	}
	
}


