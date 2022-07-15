package com.cg.OFS.service;

import java.util.List;

import com.cg.OFS.model.Bill;
import com.cg.OFS.model.Cart;
import com.cg.OFS.model.Customer;
import com.cg.OFS.model.Order;

public interface IReportService {
	
	public List<Bill> getAllBills();
	public List<Customer> getAllCustomers();
	public List<Cart> getAllCarts();
	public List<Order> getAllOrders();
}
