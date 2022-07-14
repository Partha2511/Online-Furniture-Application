package com.cg.OFS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.OFS.dao.ICustomerShoppingRepository;
import com.cg.OFS.model.Furniture;

public class CustomerShoppingServiceImpl  implements ICustomerShoppingService  {
	
    @Autowired
    ICustomerShoppingRepository customerShoppingRepo;
	

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

	//@Override
//	public Cart addtoCart(Furniture furniture) {
//		// TODO Auto-generated method stub
//		
//		cartRepo.save(furniture);
//		return cart;
//	}
//
//	@Override
//	public Order placeOrder(Order order) {
//		// TODO Auto-generated method stub
//		orderRepo.save(order);
//		return order;
//	}
	
}
