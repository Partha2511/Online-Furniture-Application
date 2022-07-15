package com.cg.OFS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.OFS.dao.ICartRepository;
import com.cg.OFS.dao.ICustomerRepository;
import com.cg.OFS.dao.ICustomerShoppingRepository;
import com.cg.OFS.dao.IFurnitureRepository;
import com.cg.OFS.dao.IOrderServiceRepository;
import com.cg.OFS.model.Cart;
import com.cg.OFS.model.Customer;
import com.cg.OFS.model.Furniture;
import com.cg.OFS.model.Order;

@Service
public class CustomerShoppingServiceImpl  implements ICustomerShoppingService  {
	
    @Autowired
    ICustomerShoppingRepository customerShoppingRepo;
	@Autowired
	ICustomerRepository custRepo;
	@Autowired
	IFurnitureRepository fRepo;
	@Autowired 
	ICartRepository  cartRepo;
	@Autowired
	IOrderServiceRepository oRepo;

	public List<Furniture> getAllFurnitures(){
		List<Furniture> flist= customerShoppingRepo.findAll();
		return flist;
	}

	@Override
	public Furniture getFurnitureByName(String furnitureName) {
		// TODO Auto-generated method stub
		Furniture furnitureByFurnitureName = customerShoppingRepo.getFurnitureByFurnitureName(furnitureName);
		if(furnitureByFurnitureName != null) {
			
			 return furnitureByFurnitureName; 
			
		}
		
		return null;
	}

	@Override
	public Cart addtoCart(Furniture furniture, int cartId) {
		// TODO Auto-generated method stub
		if(cartRepo.existsById(cartId)) {
			Furniture f = fRepo.getFurnitureByFurnitureId(furniture.getFurnitureId());
			Cart cart=cartRepo.findById(cartId).get();
			cart.getFurnitures().add(furniture);
			cart.setQuantity(cart.getQuantity()+1);
			f.getCarts().add(cart);
			fRepo.save(f);
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
			order.getCustomers().add(cust);
			custRepo.save(cust);
			//oRepo.save(order);
			return order;
		}
		
		return null;
	}

	

}
