package com.cg.OFS.service;

import java.util.List;

import com.cg.OFS.model.Cart;
import com.cg.OFS.model.Furniture;
import com.cg.OFS.model.Order;

public interface ICustomerShoppingService {
	
	public List<Furniture> getAllFurnitures();
	public Furniture getFurnitureByName(String furnitureName);

	public Cart addtoCart(Furniture furniture,int cartId);
	
	public Order placeOrder(Order order,int customerId);

}
