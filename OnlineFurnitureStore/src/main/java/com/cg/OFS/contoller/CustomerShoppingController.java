package com.cg.OFS.contoller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OFS.Exception.EmptyCartException;
import com.cg.OFS.Exception.EmptyFurnitureListException;
import com.cg.OFS.Exception.EmptyOrderException;
import com.cg.OFS.Exception.ExceptionResponse;
import com.cg.OFS.Exception.InvalidFurnitureNameException;
import com.cg.OFS.model.Cart;
import com.cg.OFS.model.Furniture;
import com.cg.OFS.model.Order;
import com.cg.OFS.service.CustomerShoppingServiceImpl;

@RestController
public class CustomerShoppingController {
	@Autowired
	CustomerShoppingServiceImpl  cserv;
	
	@GetMapping("/getAllFurnitures")
	public ResponseEntity<List<Furniture>> getAllFurnitures() throws EmptyFurnitureListException{
		List<Furniture> furnitures=cserv.getAllFurnitures();
		if(furnitures.isEmpty()){
			throw new EmptyFurnitureListException("Sorry! Furnitures are not available");
		}
		return new ResponseEntity<List<Furniture>>(furnitures,HttpStatus.OK);
	}
	@GetMapping("/getFurnitureByName/{furnitureName}")
	public ResponseEntity<Furniture> getFurnitureByName(@PathVariable("furnitureName") String furnitureName) throws InvalidFurnitureNameException{
		Furniture furniture=cserv.getFurnitureByName(furnitureName);
		if(furniture==null){
			throw new InvalidFurnitureNameException("No furnitures with given name exists");
		}
		return new ResponseEntity<Furniture>(furniture,HttpStatus.OK);
	}
	
	@PutMapping("/addToCart/{cartId}")
	public ResponseEntity<Cart> addtoCart(@RequestBody Furniture furniture,@PathVariable("cartId")int cartId) throws EmptyCartException{
		Cart cart= cserv.addtoCart(furniture,cartId);
		if(cart==null) {
			throw new EmptyCartException("Sorry! your cart is Empty");
		}
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}
	
	@PutMapping("/placeOrder/{customerId}")
	public ResponseEntity<Order> placeOrder(@RequestBody Order order,@PathVariable("customerId")int customertId) throws EmptyOrderException{
		Order ord= cserv.placeOrder(order,customertId);
		if(ord==null) {
			throw new EmptyOrderException(" Sorry ur order  doest not  exists");
		}
		return new ResponseEntity<Order>(ord,HttpStatus.OK);
	}
	
	


	
	@ExceptionHandler(EmptyFurnitureListException.class)
	public ResponseEntity<ExceptionResponse> handlEmptyFurnitureListException(EmptyFurnitureListException e) {
		ExceptionResponse response=new ExceptionResponse();//ExecptionResponse is userdefined
        response.setErrorCode("Not Found");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(InvalidFurnitureNameException.class)
	public ResponseEntity<ExceptionResponse> handleInvalidFurnitureName(EmptyFurnitureListException e) {
		ExceptionResponse response=new ExceptionResponse();//ExecptionResponse is userdefined
        response.setErrorCode("Not Found");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(EmptyCartException.class)
	public ResponseEntity<ExceptionResponse> handleEmptyCartException(EmptyCartException e) {
		ExceptionResponse response=new ExceptionResponse();
        response.setErrorCode("Not Found");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(EmptyOrderException.class)
	public ResponseEntity<ExceptionResponse> handleEmptyOrderException(EmptyOrderException e) {
		ExceptionResponse response=new ExceptionResponse();
        response.setErrorCode("Not Found");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
		
	}


}
