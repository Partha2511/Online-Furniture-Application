package com.cg.OFS.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OFS.model.Furniture;
import com.cg.OFS.service.FurnitureManagementImpl;

@RestController
@RequestMapping("/furnitureManagement")
public class FurnitureManagementController {

	@Autowired
	public FurnitureManagementImpl fimpl;
	
	@GetMapping("/furnitures")
	public ResponseEntity<List<Furniture>> getAllFurnitures() throws Exception{
		List<Furniture> furnitures=fimpl.getAllFurnitures();
		if(furnitures.isEmpty()){
			throw new Exception("Sorry! Furnitures are not available");
		}
		return new ResponseEntity<List<Furniture>>(furnitures,HttpStatus.OK);
	}
	
	@GetMapping("/furnitures/{id}")
	public ResponseEntity<Furniture> getFurnitureById(@PathVariable("id") int furnitureId) throws Exception{
		Furniture furniture=fimpl.getFurnitureById(furnitureId);
		if(furniture==null){
			throw new Exception("Furniture doesn't exist");
		}
		return new ResponseEntity<Furniture>(furniture,HttpStatus.OK);
	}
	
	@PostMapping("/furnitures")
	public ResponseEntity<Furniture> registerFurniture(@RequestBody Furniture furniture) throws Exception{
		Furniture savedfurniture=fimpl.registerFurniture(furniture);
		if(savedfurniture==null){
			throw new Exception("Operation Unsuccessful");
		}
		return new ResponseEntity<Furniture>(savedfurniture, HttpStatus.OK);
	}
	
	@PutMapping("/furnitures")
	public ResponseEntity<Furniture> updateFurniture(@RequestBody Furniture furniture) throws Exception{
		Furniture updatedFurniture=fimpl.updateFurniture(furniture);
		if(updatedFurniture==null){
			throw new Exception("Furniture not Found");
		}
		return new ResponseEntity<Furniture>(furniture,HttpStatus.OK);
	}
	
	@PutMapping("/furnitures/{id}")
	public ResponseEntity<Furniture> updateFurnitureById(@PathVariable("id") int furnitureId,@RequestBody Furniture furniture) throws Exception{
		Furniture updatedFurniture=fimpl.updateFurnitureById(furnitureId, furniture);
		if(updatedFurniture==null){
			throw new Exception("Furniture not found"); 
		}
		return new ResponseEntity<Furniture>(updatedFurniture, HttpStatus.OK);
	}
	
	@DeleteMapping("/furnitures")
	public ResponseEntity<String> deleteFurniture(@RequestBody Furniture furniture) throws Exception{
		String result=fimpl.deleteFurniture(furniture);
		if(result==null){
			throw new Exception("Furniture not exist in store");
		}
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@DeleteMapping("/furnitures/{id}")
	public ResponseEntity<String> deleteFurnitureById(@PathVariable("id") int furnitureId) throws Exception{
		String result=fimpl.deleteFurnitureById(furnitureId);
		if(result==null){
			throw new Exception("Furniture not exist in store");
		}
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
