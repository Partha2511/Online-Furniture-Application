package com.cg.OFS.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OFS.model.Order;
import com.cg.OFS.service.OrderCancellationServiceImpl;

@RestController
public class OrderCancellationController {
	
	@Autowired
	public OrderCancellationServiceImpl ocimpl;
	
	@DeleteMapping("/Order/deleteOrder")
	public ResponseEntity<String> deleteOrder(Order order) throws Exception{
		String result=ocimpl.deleteOrder(order);
		if(result==null){
			throw new Exception("Order doesnot exist in store");
		}
		return new ResponseEntity<String>(result,HttpStatus.OK);
}
	
	@DeleteMapping("/Order/deleteOrderById/{orderId}")
	public ResponseEntity<String> deleteOrderById(@PathVariable("orderId") String orderId) throws Exception{
		String result=ocimpl.deleteOrderById(orderId);
		if(result==null){
			throw new Exception("Order doesnot exist in store");
		}
		return new ResponseEntity<String>(result,HttpStatus.OK);
}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

}
