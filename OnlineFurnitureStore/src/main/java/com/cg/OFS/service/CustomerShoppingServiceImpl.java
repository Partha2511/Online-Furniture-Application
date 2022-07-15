package com.cg.OFS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.OFS.dao.ICartRepository;
import com.cg.OFS.dao.ICustomerRepository;
import com.cg.OFS.dao.ICustomerShoppingRepository;
import com.cg.OFS.model.Cart;
import com.cg.OFS.model.Customer;
import com.cg.OFS.model.Furniture;
import com.cg.OFS.model.Order;

public class CustomerShoppingServiceImpl  implements ICustomerShoppingService  {
	
    @Autowired
    ICustomerShoppingRepository customerShoppingRepo;
	@Autowired
	ICustomerRepository custRepo;
	
	@Autowired 
	ICartRepository  cartRepo;

	public List<Furniture> getAllFurnitures(){
		List<Furniture> flist= customerShoppingRepo.findAll();
		return flist;
	}

	@Override
	public Furniture getFurnitureByName(String furnitureName) {
		// TODO Auto-generated method stub
		if(customerShoppingRepo.getFurnitureByFurnitureName(furnitureName) != null) {
			
			 customerShoppingRepo.findAll();
			
		}
		
		return null;
	}

	@Override
	public Cart addtoCart(Furniture furniture, int cartId) {
		// TODO Auto-generated method stub
		if(cartRepo.existsById(cartId)) {
			Cart cart=cartRepo.findById(cartId).get();
			cart.getFurnitures().add(furniture);
			cartRepo.save(cart);
			return cart;
		}
		return null;
	}

	@Override
	public Order placeOrder(Order order, int customerId) {
		// TODO Auto-generated method stub
		if(custRepo.existsById(customerId)){
			Customer cust=custRepo.findById(customerId).get();
			cust.getOrders().add(order);
			custRepo.save(cust);
			return order;
		}
		
		return null;
	}

	

}
