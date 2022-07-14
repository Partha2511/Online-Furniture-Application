package com.cg.OFS.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OFS.model.Order;
import com.cg.OFS.service.OrderServiceImpl;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController{
	@Autowired
	OrderServiceImpl impl;
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<List<Order>> getAllOrders() throws Exception {
		List<Order> order= impl.getAllOrders();
		if(order.isEmpty()) {
			throw new Exception("Sorry! Order is not Found");
		}
		return new ResponseEntity<List<Order>>(order,HttpStatus.OK);
	}
	
//	@GetMapping("/status")
//	public ResponseEntity <Order> getOrderByStatus(String status) throws Exception{
//		return null;
//		
//	}
	
	@PutMapping("/updateOrder")
	public ResponseEntity  <Order> updateOrder(Order order) throws Exception{
		Order updateOrder= impl.updateOrder(order);
		if(updateOrder==null) {
			throw new Exception("Order not Found");
		}
		return new ResponseEntity<Order>(order,HttpStatus.OK);
		
	}
	
//	@PutMapping("/updateOrderById")
//	public ResponseEntity <Order> updateOrderById(String orderId) throws Exception{
//		Order updateOrderById= impl.updateOrderById(orderId);
//		if(updateOrderById==null) {
//			throw new Exception("Order not Found");
//		}
//		return new ResponseEntity<orderId>(orderId,HttpStatus.OK);
//	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}
