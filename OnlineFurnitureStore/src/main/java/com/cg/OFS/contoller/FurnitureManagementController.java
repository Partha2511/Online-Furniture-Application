package com.cg.OFS.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OFS.model.Furniture;
import com.cg.OFS.service.FurnitureManagementImpl;

@RestController
public class FurnitureManagementController {
//	public List<Furniture> getAllFurnitures();
//	public Furniture getFurnitureById(int furnitureId);
//	public Furniture registerFurniture(Furniture furniture);
//	public Furniture updateFurniture(Furniture furniture);
//	public Furniture updateFurnitureById(int furnitureId,Furniture furniture);
//	public String deleteFurniture(Furniture furniture);
//	public String deleteFurnitureById(int furnitureId);
	
	@Autowired
	public FurnitureManagementImpl fimpl;
	
	public ResponseEntity<List<Furniture>> getAllFurnitures() throws Exception{
		List<Furniture> furnitures=fimpl.getAllFurnitures();
		if(furnitures.isEmpty()){
			throw new Exception("Sorry! Furnitures are not available");
		}
		return new ResponseEntity<List<Furniture>>(furnitures,HttpStatus.OK);
	}
	
	public ResponseEntity<Furniture> getFurnitureById(int furnitureId) throws Exception{
		Furniture furniture=fimpl.getFurnitureById(furnitureId);
		if(furniture==null){
			throw new Exception("Furniture doesn't exist");
		}
		return new ResponseEntity<Furniture>(furniture,HttpStatus.OK);
	}
	
	public ResponseEntity<Furniture> registerFurniture(Furniture furniture) throws Exception{
		Furniture savedfurniture=fimpl.registerFurniture(furniture);
		if(savedfurniture==null){
			throw new Exception("Operation Unsuccessful");
		}
		return new ResponseEntity<Furniture>(savedfurniture, HttpStatus.OK);
	}
	
	public ResponseEntity<Furniture> updateFurniture(@RequestBody Furniture furniture) throws Exception{
		Furniture updatedFurniture=fimpl.updateFurniture(furniture);
		if(updatedFurniture==null){
			throw new Exception("Furniture not Found");
		}
		return new ResponseEntity<Furniture>(furniture,HttpStatus.OK);
	}
	
	public ResponseEntity<Furniture> updateFurnitureById(@PathVariable int furnitureId,@RequestBody Furniture furniture) throws Exception{
		Furniture updatedFurniture=fimpl.updateFurnitureById(furnitureId, furniture);
		if(updatedFurniture==null){
			throw new Exception("Furniture not found"); 
		}
		return new ResponseEntity<Furniture>(updatedFurniture, HttpStatus.OK);
	}
	
	public String deleteFurniture(Furniture furniture)
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
