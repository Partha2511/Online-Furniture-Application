package com.cg.OFS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.OFS.dao.ICartRepository;
import com.cg.OFS.dao.ICustomerRepository;
import com.cg.OFS.dao.IOrderServiceRepository;
import com.cg.OFS.dao.IPaymentRepository;
import com.cg.OFS.model.Bill;
import com.cg.OFS.model.Cart;
import com.cg.OFS.model.Customer;
import com.cg.OFS.model.Order;

@Service
public class ReportServiceImpl implements IReportService{
	
	@Autowired
	private IPaymentRepository billRepo;
	
	@Autowired
	private ICustomerRepository custRepo;
	
	@Autowired
	private ICartRepository cartRepo;
	
	@Autowired
	private IOrderServiceRepository orderRepo;
	
	@Override
	public List<Bill> getAllBills() {
		return billRepo.findAll();
	}

	@Override
	public List<Customer> getAllCustomers() {
		return custRepo.findAll();
	}

	@Override
	public List<Cart> getAllCarts() {
		return cartRepo.findAll();
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}
	


}
