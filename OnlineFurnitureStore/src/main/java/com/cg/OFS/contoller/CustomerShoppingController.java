package com.cg.OFS.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OFS.model.Furniture;
import com.cg.OFS.service.CustomerShoppingServiceImpl;

@RestController
public class CustomerShoppingController {
	@Autowired
	CustomerShoppingServiceImpl  cserv;
	
	@GetMapping("/getAllFurnitures")
	public ResponseEntity<List<Furniture>> getAllFurnitures() throws Exception{
		List<Furniture> furnitures=cserv.getAllFurnitures();
		if(furnitures.isEmpty()){
			throw new Exception("Sorry! Furnitures are not available");
		}
		return new ResponseEntity<List<Furniture>>(furnitures,HttpStatus.OK);
	}
	@GetMapping("/getFurnitureByName/{furnitureName}")
	public ResponseEntity<Furniture> getFurnitureByName(@PathVariable("furnitureName") String furnitureName) throws Exception{
		Furniture furniture=cserv.getFurnitureByName(furnitureName);
		if(furniture==null){
			throw new Exception("Furniture name does not exist");
		}
		return new ResponseEntity<Furniture>(furniture,HttpStatus.OK);
	}
	

	//Cart addtoCart(Furniture furniture);
	
	//Order placeOrder(Order order);


	
		@ExceptionHandler(Exception.class)
		public ResponseEntity<String> handleException(Exception e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}


}
