package com.cg.OFS.service;


import com.cg.OFS.model.Cart;


import java.util.List;



public interface ICartService {
	public List<Cart> getAllCarts();
	public Cart getCartByCartId(int cartId);
	public Cart updateCart(Cart cart);
	public Cart updateCartById(int cartId, Cart cart);
	public Cart deleteCart(Cart cart);
	public Cart deleteCartById(int cartId);
	

}
