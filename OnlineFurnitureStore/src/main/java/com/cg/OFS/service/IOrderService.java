package com.cg.OFS.service;

import java.util.List;

import com.cg.OFS.model.Order;

public interface IOrderService {
	List<Order>getAllOrders();
	Order getOrderByStatus(String status);
	Order updateOrder(Order order);
//	Order updateOrderById(String orderId);
}
