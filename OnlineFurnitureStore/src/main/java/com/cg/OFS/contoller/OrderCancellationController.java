package com.cg.OFS.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OFS.Exception.NoSuchOrderException;
import com.cg.OFS.model.Order;
import com.cg.OFS.service.OrderCancellationServiceImpl;

@CrossOrigin("*")
@RestController
public class OrderCancellationController {
	
	@Autowired
	public OrderCancellationServiceImpl ocimpl;
	
	@DeleteMapping("/Order/deleteOrder")
	public ResponseEntity<Integer> deleteOrder(@RequestBody Order order) throws NoSuchOrderException{
		Integer result=ocimpl.deleteOrder(order);
		if(result==null){
			throw new NoSuchOrderException("Order doesnot exist in store");
		}
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
}
	
	@DeleteMapping("/Order/deleteOrderById/{orderId}")
	public ResponseEntity<Integer> deleteOrderById(@PathVariable("orderId") Integer orderId) throws NoSuchOrderException{
		Integer result=ocimpl.deleteOrderById(orderId);
		if(result==null){
			throw new NoSuchOrderException("Order with Id "+orderId+" doesnot exist in store");
		}
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	


}
