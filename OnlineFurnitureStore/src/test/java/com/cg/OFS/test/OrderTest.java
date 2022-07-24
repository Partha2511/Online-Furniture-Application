package com.cg.OFS.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.OFS.model.Order;
import com.cg.OFS.service.OrderServiceImpl;

@SpringBootTest
class OrderTest {

	@Autowired
	private OrderServiceImpl oserve;
	
	@Test
	void testGetAllOrders() {
		List<Order> order = oserve.getAllOrders();
		assertTrue(order.size()!=0);	
	}
	
	@Test
	void testGetOrderByOrderId() {
		Order o = oserve.getOrderById(19);
		assertEquals(106000,o.getPrice());
		assertEquals(2, o.getQuantity());
	}
	
	@Test
	void testGetOrderByStatus() {
		List<Order> order=oserve.getOrderByStatus("Delivered");
		assertTrue(order.size()!=0);
	}
	
	@Test
	void testGetOrderByCustomer() {
		List<Order> order=oserve.getOrderByCustomer(30);
		assertTrue(order.size()!=0);
	}
	
	@Test
	void testUpdateOrder() {
		Order o =oserve.getOrderById(19);
		o.setStatus("Undelievered");
		Order result=oserve.updateOrder(o);
		assertEquals(o.getStatus(),result.getStatus());
	}

}
