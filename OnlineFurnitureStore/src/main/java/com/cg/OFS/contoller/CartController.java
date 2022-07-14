package com.cg.OFS.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.OFS.model.Cart;
import com.cg.OFS.service.ICartServiceImpl;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartController {
	@Autowired
	ICartServiceImpl impl;
	
	@GetMapping("/getAllCarts")
	public ResponseEntity<List<Cart>> getAllCarts() throws Exception{
		return new ResponseEntity<List<Cart>>(impl.getAllCarts(), HttpStatus.OK);
	}
	public ResponseEntity<Cart> getCartByCartId(int cartId) throws Exception{
		Cart cart=impl.getCartByCartId(cartId);
		if(cart==null){
			throw new Exception("Cart doesn't exist");
		}
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}
	public ResponseEntity<Cart> updateCart(@RequestBody Cart cart) throws Exception{
		Cart updatedCart=impl.updateCart(cart);
		if(updatedCart==null){
			throw new Exception("Cart not Found");
		}
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}
	public ResponseEntity<Cart> updateCartById(@PathVariable int cartId,@RequestBody Cart cart) throws Exception{
		Cart updatedCart=impl.updateCartById(cartId);
		if(updatedCart==null){
			throw new Exception("Cart not found"); 
		}
		return new ResponseEntity<Cart>(updatedCart, HttpStatus.OK);
	}
	public ResponseEntity<Cart> deleteCart(Cart cart) throws Exception{
		Cart result=impl.deleteCart(cart);
		if(result==null){
			throw new Exception("Cart does not exist");
		}
		return new ResponseEntity<Cart>(HttpStatus.OK);
	}
	
	public ResponseEntity<Cart> deleteCartById(int cartId) throws Exception{
		Cart result=impl.deleteCartById(cartId);
		if(result==null){
			throw new Exception("Cart does not exist");
		}
		return new ResponseEntity<Cart>(HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}
