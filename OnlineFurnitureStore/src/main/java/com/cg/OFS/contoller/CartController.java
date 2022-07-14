package com.cg.OFS.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

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
	public ResponseEntity<List<Cart>> getAllCarts() {
		return new ResponseEntity<List<Cart>>(impl.getAllCarts(), HttpStatus.OK);
	}
	
	
}
