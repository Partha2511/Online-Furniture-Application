package com.cg.OFS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.OFS.dao.ICartRepository;
import com.cg.OFS.model.Cart;


@Service
public class ICartServiceImpl implements ICartService{
	@Autowired
	ICartRepository repo;

	public List<Cart> getAllCarts(){
		List<Cart> cartlist=repo.findAll();
		return cartlist;
	}
	public Cart getCartByCartId(int cartId) {
		Cart cartByCartId = repo.getCartByCartId(cartId);
		if(cartByCartId!=null )
			return cartByCartId;
		return null;

	}
	public Cart updateCart(Cart cart) {
		if(repo.existsById(cart.getCartId())) {
			repo.save(cart);
			
		}
		return cart;
		
	}
	@Override
	public Cart updateCartById(int cartId, Cart cart) {
		if(repo.existsById(cartId)) {
			return repo.save(cart);
			
		}
		return null;
	}
	public Cart deleteCart(Cart cart) {
		if(repo.existsById(cart.getCartId())) {
			Cart c=repo.findById(cart.getCartId()).get();
			repo.deleteById(cart.getCartId());
			return c;
		}
		return null;
		}
	
	public Cart deleteCartById(int cartId)  {
		if(repo.existsById(cartId)) {
			Cart c=repo.findById(cartId).get();
			repo.deleteById(cartId);
			return c;
		}
		return null;
		
		
		
	}
	

}
