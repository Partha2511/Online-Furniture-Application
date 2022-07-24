package com.cg.OFS.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.OFS.model.Address;
import com.cg.OFS.model.Cart;
import com.cg.OFS.model.Customer;
import com.cg.OFS.service.UserManagementServiceImpl;

@SpringBootTest
class UserManagementTests {

	@Autowired
	private UserManagementServiceImpl userve;
	
	
	
	@Test
	void testLoginUser() {
		String userName="Ankita";
		String password="sahu";
		String role="Customer";
		
		Customer c = userve.loginUser(userName, password, role);
		assertEquals("Ankita",c.getUsername());
		assertEquals("sahu",c.getPassword());
		
	}
	
	@Test
	void testResgisterNewCustomer() {
		Address a = new Address();
		a.setCity("Cuttack");
		a.setState("Odisha");
		a.setCountry("India");
		a.setPincode("768876");
		Cart c = new Cart();
		c.setQuantity(0);
		Customer cust = new Customer();
		cust.setUsername("Bhoomija");
		cust.setMobileNo("9988998899");
		cust.setEmail("bhoomija@ray.com");
		cust.setPassword("ray9");
		cust.setRole("Customer");
		cust.setCart(c);
		cust.getAddresses().add(a);
		Customer result = userve.registerNewUser(cust);
		assertEquals(cust.getUsername(), result.getUsername());
		
	}

	@Test
	void testUpdateCustomer() {
		Customer cust = new Customer();
		cust.setUid(90);
		cust.setUsername("Bhoomija");
		cust.setMobileNo("9988998899");
		cust.setEmail("bhoomija@ray.com");
		cust.setPassword("ray9");
		cust.setRole("Customer");
		Customer result = userve.updateUser(cust);
		assertEquals(null, result);
		
	}
	
	@Test
	void testDeleteCustomerById() {
		String result = userve.deleteUserById(40);
		assertEquals("Bhoomija", result);
		
	}
}
