package com.cg.OFS.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.OFS.model.Furniture;
import com.cg.OFS.service.FurnitureManagementImpl;

@SpringBootTest
class FurnitureManagementTest {
	
	@Autowired
	private FurnitureManagementImpl impl;
	
	@Test
	void testGetAllFurnitures() {
		assertTrue(impl.getAllFurnitures().size()!=0);
	}
	
	@Test
	void testGetFurnitureById() {
		Furniture f=impl.getFurnitureById(4);
		assertEquals("Dinning Table",f.getFurnitureName());
		assertEquals(100000,f.getPrice());
	}
	
	@Test
	void testUpdateFurniture() {
		Furniture f=impl.getFurnitureById(37);
		f.setPrice(20000);
		Furniture result=impl.updateFurniture(f);
		assertEquals(f.getPrice(),result.getPrice());
	}
	
	@Test
	void testRegisterFurniture() {
		Furniture f=new Furniture();
		f.setImgUrl("https://images.pexels.com/photos/1350789/pexels-photo-1350789.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
		f.setFurnitureColor("Orange Green");
		f.setFurnitureModel("Funky Chairs");
		f.setPrice(30000);
		f.setFurnitureName("Chairs");
		Furniture result=impl.registerFurniture(f);
		assertEquals(f.getPrice(),result.getPrice());
		assertEquals(f.getFurnitureName(),result.getFurnitureName());
	}
	
	@Test
	void testDeleteFurniture() {
		Furniture f=impl.getFurnitureById(46);
		String result=impl.deleteFurniture(f);
		assertEquals(f.getFurnitureName(),result);
	}
}
