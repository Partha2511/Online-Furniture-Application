package com.cg.OFS.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.cg.OFS.model.Order;
import com.cg.OFS.service.OrderCancellationServiceImpl;

@RestController
public class OrderCancellationController {
	
	@Autowired
	public OrderCancellationServiceImpl ocimpl;

	public ResponseEntity<String> deleteOrder(Order order) throws Exception{
		String result=ocimpl.deleteOrder(order);
		if(result==null){
			throw new Exception("Order not exist in store");
		}
		return new ResponseEntity<String>(result,HttpStatus.OK);
}

	public ResponseEntity<String> deleteOrderById(String orderId) throws Exception{
		String result=ocimpl.deleteOrderById(orderId);
		if(result==null){
			throw new Exception("Order not exist in store");
		}
		return new ResponseEntity<String>(result,HttpStatus.OK);
}
	
	

}
