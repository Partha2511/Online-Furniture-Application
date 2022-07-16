package com.cg.OFS.contoller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OFS.Exception.EmptyOrderException;
import com.cg.OFS.Exception.ExceptionResponse;
import com.cg.OFS.Exception.InvalidOrderByIdException;
import com.cg.OFS.Exception.InvalidOrderException;
import com.cg.OFS.Exception.InvalidStatusException;
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
			throw new EmptyOrderException("Sorry! Order is not Found");
		}
		return new ResponseEntity<List<Order>>(order,HttpStatus.OK);
	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<List<Order>> getOrderByStatus(@PathVariable("status")String status) throws Exception{
		List<Order> orders = impl.getOrderByStatus(status);
		if(orders.size()==0) {
			throw new InvalidStatusException("No order found with this status!!!");
		}
		return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateOrder")
	public ResponseEntity  <Order> updateOrder(@RequestBody Order order) throws Exception{
		Order updateOrder= impl.updateOrder(order);
		if(updateOrder==null) {
			throw new InvalidOrderException("No Order Found");
			
		}
		return new ResponseEntity<Order>(order,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateOrderById/{orderId}")
	public ResponseEntity <Order> updateOrderById(@PathVariable("orderId")Integer orderId,@RequestBody Order order) throws Exception{
		Order updateOrderById= impl.updateOrderById(orderId,order);
		if(updateOrderById==null) {
			throw new InvalidOrderByIdException("Order not Found");
		}
		return new ResponseEntity<Order>(updateOrderById,HttpStatus.OK);
	}
	
	@ExceptionHandler(EmptyOrderException.class)
	public ResponseEntity<ExceptionResponse> handlEmptyOrderException1(EmptyOrderException e) {
		ExceptionResponse response=new ExceptionResponse();
        response.setErrorCode("Not Found");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(InvalidStatusException.class)
	public ResponseEntity<ExceptionResponse> handlInvalidStatusException1(InvalidStatusException e) {
		ExceptionResponse response=new ExceptionResponse();
        response.setErrorCode("Not Found");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(InvalidOrderException.class)
	public ResponseEntity<ExceptionResponse> handlInvalidOrderException1(InvalidOrderException e) {
		ExceptionResponse response=new ExceptionResponse();
        response.setErrorCode("Not Found");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(InvalidOrderByIdException.class)
	public ResponseEntity<ExceptionResponse> handlInvalidOrderByIdException(InvalidOrderByIdException e) {
		ExceptionResponse response=new ExceptionResponse();
        response.setErrorCode("Not Found");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e){
		e.printStackTrace();
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		
	}
	
}
