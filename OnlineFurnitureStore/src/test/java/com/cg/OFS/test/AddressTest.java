package com.cg.OFS.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.OFS.model.Address;
import com.cg.OFS.service.AddressServiceImpl;
@SpringBootTest
class AddressTest {
	@Autowired
	private AddressServiceImpl impl;

	@Test
	void testAddAddress() {
		int userId =30;
		Address add =new Address();
		add.setCity("Bhubaneswar");
		add.setCountry("India");
		add.setState("Odisha");
		add.setPincode("751024");
		
		Address ad =impl.addAddress(userId, add);
		assertEquals(add.getCity(), ad.getCity());
		assertEquals(add.getPincode(), ad.getPincode());
		
	}
	
	@Test
	void testUpdateAddress() {
		Address ad=new Address();
		ad.setAid(43);
		ad.setCity("BBSR");
		ad.setState("OD");
		ad.setCountry("IND");
		ad.setPincode("751025");
		
		Address result=impl.updateAddress(30, ad);
		assertEquals(ad.getCity(),result.getCity());
		assertEquals(ad.getPincode(),result.getPincode());
	}
	
	@Test
	void testDeleteAddress() {
		Address result= impl.deleteAddress(30, 43);
		assertEquals("BBSR", result.getCity());
		assertEquals("OD", result.getState());
		
	}
	@Test
	void testGetAddress() {
		List<Address> adList= impl.getAllAddresss(90);
		assertEquals(null, adList);
	}

}
