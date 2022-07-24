package com.cg.OFS.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.OFS.model.Cart;
import com.cg.OFS.service.ICartServiceImpl;
@SpringBootTest
class CartTest {
	@Autowired
	private ICartServiceImpl cserve;

	@Test
	void testGetAllCart() {
		List<Cart>  cartList=cserve.getAllCarts();
		assertTrue(cartList.size()!=0);
	}
	@Test
	void testGetCartById() {
		Cart cart=cserve.getCartByCartId(31);
		assertEquals(1,cart.getQuantity());
	}
	@Test
	void testUpdateCart() {
		Cart cart=cserve.updateCartById(90,new Cart());
		assertEquals(null,cart);
	}
	@Test
	void testDeleteCart() {
		Cart cart=cserve.deleteCartById(90);
		assertEquals(null,cart);
	}
	

}
