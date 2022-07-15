package com.cg.OFS.service;

import java.util.List;

import com.cg.OFS.model.Order;

public interface IOrderService {
	public List<Order>getAllOrders();
	public List<Order> getOrderByStatus(String status);
	public Order updateOrder(Order order);
	public Order updateOrderById(int orderId,Order order);
}
