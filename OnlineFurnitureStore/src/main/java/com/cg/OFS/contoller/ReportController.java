package com.cg.OFS.contoller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.OFS.Exception.DataNotFoundException;
import com.cg.OFS.Exception.ExceptionResponse;
import com.cg.OFS.model.Bill;
import com.cg.OFS.model.Cart;
import com.cg.OFS.model.Customer;
import com.cg.OFS.model.Order;
import com.cg.OFS.service.ReportServiceImpl;

@CrossOrigin("*")
@RestController
public class ReportController {
	
	@Autowired
	public ReportServiceImpl rimpl;
	
	@GetMapping("/getAllBills")
	public ResponseEntity<List<Bill>> getAllBills() throws DataNotFoundException{
		List<Bill> bills=rimpl.getAllBills();
		if(bills.isEmpty()){
			throw new DataNotFoundException("Sorry no bills available!");
		}
		return new ResponseEntity<List<Bill>>(rimpl.getAllBills(),HttpStatus.OK);
	}
	
	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() throws DataNotFoundException{
		List<Customer> customers=rimpl.getAllCustomers();
		if(customers.isEmpty()){
			throw new DataNotFoundException("Sorry no customers available!");
		}
		return new ResponseEntity<List<Customer>>(rimpl.getAllCustomers(),HttpStatus.OK);
	}
	
	@GetMapping("/getAllCarts")
	public ResponseEntity<List<Cart>> getAllCarts() throws DataNotFoundException{
		List<Cart> carts=rimpl.getAllCarts();
		if(carts.isEmpty()){
			throw new DataNotFoundException("Sorry no carts available!");
		}
		return new ResponseEntity<List<Cart>>(rimpl.getAllCarts(),HttpStatus.OK);
	}
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<List<Order>> getAllOrders() throws DataNotFoundException{
		List<Order> orders=rimpl.getAllOrders();
		if(orders.isEmpty()){
			throw new DataNotFoundException("Sorry no orders available!");
		}
		return new ResponseEntity<List<Order>>(rimpl.getAllOrders(),HttpStatus.OK);
	}
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleException(Exception e){
//		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//	}
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleDataNotFoundException(DataNotFoundException e) {
		ExceptionResponse response=new ExceptionResponse();
	    response.setErrorCode("NOT_FOUND");
	    response.setErrorMessage(e.getMessage());
	    response.setTimestamp(LocalDateTime.now());
	    return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
			
	}
	
}
