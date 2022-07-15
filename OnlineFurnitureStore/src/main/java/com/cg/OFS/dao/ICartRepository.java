package com.cg.OFS.dao;


import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.OFS.model.Cart;

public interface ICartRepository extends JpaRepository<Cart, Integer>{
	
	
	public Cart getCartByCartId(int cartId);

	
	
	

}
