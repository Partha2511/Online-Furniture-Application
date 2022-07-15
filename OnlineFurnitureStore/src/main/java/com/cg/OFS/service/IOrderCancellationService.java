package com.cg.OFS.service;

import com.cg.OFS.model.Order;

public interface IOrderCancellationService {
	public String deleteOrder(Order order);
	public String deleteOrderById(String orderId);

}
