package com.cg.OFS.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.OFS.model.Cart;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer>{
	
	
	public Cart getCartByCartId(int cartId);

	
	
	

}
