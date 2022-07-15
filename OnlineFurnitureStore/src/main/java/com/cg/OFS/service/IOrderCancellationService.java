package com.cg.OFS.service;

import com.cg.OFS.model.Order;

public interface IOrderCancellationService {
	public Integer deleteOrder(Order order);
	public Integer deleteOrderById(Integer orderId);

}
