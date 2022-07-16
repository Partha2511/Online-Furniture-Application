package com.cg.OFS.contoller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cg.OFS.Exception.ExceptionResponse;
import com.cg.OFS.Exception.NoCartFoundException;
import com.cg.OFS.Exception.NoSuchCartFoundException;
import com.cg.OFS.model.Cart;
import com.cg.OFS.service.ICartServiceImpl;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartController {
	@Autowired
	ICartServiceImpl impl;
	
	@GetMapping("/getAllCarts")
	public ResponseEntity<List<Cart>> getAllCarts() throws NoCartFoundException{
		return new ResponseEntity<List<Cart>>(impl.getAllCarts(), HttpStatus.OK);
	}
	
	@GetMapping("/getAllCartsById/{cartId}")
	public ResponseEntity<Cart> getCartByCartId(@PathVariable("cartId")int cartId) throws NoSuchCartFoundException{
		Cart cart=impl.getCartByCartId(cartId);
		if(cart==null){
			throw new NoSuchCartFoundException("Cart doesn't exist with the given id");
		}
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}
	
	@PutMapping("/updateCart")
	public ResponseEntity<Cart> updateCart(@RequestBody Cart cart) throws NoSuchCartFoundException{
		Cart updatedCart=impl.updateCart(cart);
		if(updatedCart==null){
			throw new NoSuchCartFoundException("No such cart is found");
		}
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}
	
	@PutMapping("/updateCartById/{cartId}")
	public ResponseEntity<Cart> updateCartById(@PathVariable("cartId") int cartId,@RequestBody Cart cart) throws NoSuchCartFoundException{
		Cart updatedCart=impl.updateCartById(cartId, cart);
		if(updatedCart==null){
			throw new NoSuchCartFoundException("No such cart with this id exist"); 
		}
		return new ResponseEntity<Cart>(updatedCart, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCart")
	public ResponseEntity<Cart> deleteCart(@RequestBody Cart cart) throws NoSuchCartFoundException{
		Cart result=impl.deleteCart(cart);
		if(result==null){
			throw new NoSuchCartFoundException("No such cart exist");
		}
		return new ResponseEntity<Cart>(result,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCartById/{cartId}")
	public ResponseEntity<Cart> deleteCartById(@PathVariable("cartId")int cartId) throws NoSuchCartFoundException{
		Cart result=impl.deleteCartById(cartId);
		if(result==null){
			throw new NoSuchCartFoundException("Cart does not exist with the given id");
		}
		return new ResponseEntity<Cart>(result, HttpStatus.OK);
	}
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleException(Exception e){
//		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//	}
	
	  @ExceptionHandler(NoSuchCartFoundException.class)
		public ResponseEntity<ExceptionResponse> handleNoSuchCartFoundException(NoSuchCartFoundException e) {
			ExceptionResponse response=new ExceptionResponse();
	        response.setErrorCode("CONFLICT");
	        response.setErrorMessage(e.getMessage());
	        response.setTimestamp(LocalDateTime.now());

	        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
			
		}
	  
	  @ExceptionHandler(NoCartFoundException.class)
		public ResponseEntity<ExceptionResponse> handleNoCartFoundException(NoCartFoundException e) {
			ExceptionResponse response=new ExceptionResponse();
	        response.setErrorCode("CONFLICT");
	        response.setErrorMessage(e.getMessage());
	        response.setTimestamp(LocalDateTime.now());

	        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
			
		}
	  
	
}
