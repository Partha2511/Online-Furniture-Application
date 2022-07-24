package com.cg.OFS.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.OFS.model.Cart;
import com.cg.OFS.model.Furniture;
import com.cg.OFS.model.Order;
import com.cg.OFS.service.CustomerShoppingServiceImpl;
@SpringBootTest
class CustomerShoppingTest {
	@Autowired
	private CustomerShoppingServiceImpl impl;

	@Test
	void testGetAllFurnitures() {
		List<Furniture> furList=impl.getAllFurnitures();
		assertTrue(furList.size()!=0);
	}
	@Test
	void testAddToCart() {
		Furniture fur=new Furniture();
		fur.setFurnitureId(4);
		fur.setFurnitureName("Dinning Table");
		fur.setImgUrl( "https://images.pexels.com/photos/1457841/pexels-photo-1457841.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
		fur.setFurnitureColor("White");
		fur.setFurnitureModel("Marble");
		fur.setPrice(100000.0);
		Cart c =impl.addtoCart(fur, 90);
		assertEquals(null, c);
	}
	@Test
	void testPlaceOrder() {
		Order o=impl.placeOrder(new Order(), 90);
		assertEquals(null, o);	
		
		}
}
