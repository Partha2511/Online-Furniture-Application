package com.cg.OFS.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.cg.OFS.model.Bill;
import com.cg.OFS.model.Cart;
import com.cg.OFS.model.Customer;
import com.cg.OFS.model.Order;
import com.cg.OFS.service.ReportServiceImpl;

@RestController
public class ReportController {
	
	@Autowired
	public ReportServiceImpl rimpl;
	
	public ResponseEntity<List<Bill>> getAllBills() throws Exception{
		List<Bill> bills=rimpl.getAllBills();
		if(bills.isEmpty()){
			throw new Exception("Sorry! Bills are not available");
		}
		return new ResponseEntity<List<Bill>>(rimpl.getAllBills(),HttpStatus.OK);
	}
	
	public ResponseEntity<List<Customer>> getAllCustomers() throws Exception{
		List<Customer> customers=rimpl.getAllCustomers();
		if(customers.isEmpty()){
			throw new Exception("Sorry! Customers are not available");
		}
		return new ResponseEntity<List<Customer>>(rimpl.getAllCustomers(),HttpStatus.OK);
	}
	
	public ResponseEntity<List<Cart>> getAllCarts() throws Exception{
		List<Cart> carts=rimpl.getAllCarts();
		if(carts.isEmpty()){
			throw new Exception("Sorry! Carts are not available");
		}
		return new ResponseEntity<List<Cart>>(rimpl.getAllCarts(),HttpStatus.OK);
	}

	public ResponseEntity<List<Order>> getAllOrders() throws Exception{
		List<Order> orders=rimpl.getAllOrders();
		if(orders.isEmpty()){
			throw new Exception("Sorry! Orders are not available");
		}
		return new ResponseEntity<List<Order>>(rimpl.getAllOrders(),HttpStatus.OK);
	}
	
}
