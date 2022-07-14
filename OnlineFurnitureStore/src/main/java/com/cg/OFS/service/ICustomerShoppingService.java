package com.cg.OFS.service;

import java.util.List;

import com.cg.OFS.model.Cart;
import com.cg.OFS.model.Furniture;
import com.cg.OFS.model.Order;

public interface ICustomerShoppingService {
	
	public List<Furniture> getAllFurnitures();
	public Furniture getFurnitureByName(String furnitureName);

	//Cart addtoCart(Furniture furniture);
	
	//Order placeOrder(Order order);

}
