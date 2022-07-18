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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OFS.Exception.ExceptionResponse;
import com.cg.OFS.Exception.FurnitureDoesnotExistException;
import com.cg.OFS.Exception.NoFurnituresFoundException;
import com.cg.OFS.model.Furniture;
import com.cg.OFS.service.FurnitureManagementImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/furnitureManagement")
public class FurnitureManagementController {

	@Autowired
	public FurnitureManagementImpl fimpl;
	
	@GetMapping("/furnitures")
	public ResponseEntity<List<Furniture>> getAllFurnitures() throws NoFurnituresFoundException{
		List<Furniture> furnitures=fimpl.getAllFurnitures();
		if(furnitures.isEmpty()){
			throw new NoFurnituresFoundException("Sorry! Furnitures are not available");
		}
		return new ResponseEntity<List<Furniture>>(furnitures,HttpStatus.OK);
	}
	
	@GetMapping("/furnitures/{id}")
	public ResponseEntity<Furniture> getFurnitureById(@PathVariable("id") long furnitureId) throws FurnitureDoesnotExistException{
		Furniture furniture=fimpl.getFurnitureById(furnitureId);
		if(furniture==null){
			throw new FurnitureDoesnotExistException("Furniture doesn't exist");
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
	public ResponseEntity<Furniture> updateFurniture(@RequestBody Furniture furniture) throws FurnitureDoesnotExistException{
		Furniture updatedFurniture=fimpl.updateFurniture(furniture);
		if(updatedFurniture==null){
			throw new FurnitureDoesnotExistException("Furniture not Found");
		}
		return new ResponseEntity<Furniture>(furniture,HttpStatus.OK);
	}
	
	@PutMapping("/furnitures/{id}")
	public ResponseEntity<Furniture> updateFurnitureById(@PathVariable("id") long furnitureId,@RequestBody Furniture furniture) throws FurnitureDoesnotExistException{
		Furniture updatedFurniture=fimpl.updateFurnitureById(furnitureId, furniture);
		if(updatedFurniture==null){
			throw new FurnitureDoesnotExistException("Furniture not found"); 
		}
		return new ResponseEntity<Furniture>(updatedFurniture, HttpStatus.OK);
	}
	
	@DeleteMapping("/furnitures")
	public ResponseEntity<String> deleteFurniture(@RequestBody Furniture furniture) throws FurnitureDoesnotExistException{
		String result=fimpl.deleteFurniture(furniture);
		if(result==null){
			throw new FurnitureDoesnotExistException("Furniture not exist in store");
		}
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@DeleteMapping("/furnitures/{id}")
	public ResponseEntity<String> deleteFurnitureById(@PathVariable("id") long furnitureId) throws FurnitureDoesnotExistException{
		String result=fimpl.deleteFurnitureById(furnitureId);
		if(result==null){
			throw new FurnitureDoesnotExistException("Furniture not exist in store");
		}
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@ExceptionHandler(FurnitureDoesnotExistException.class)
	public ResponseEntity<ExceptionResponse> handleFurnitureDoesNotExistException(Exception e){
		ExceptionResponse response=new ExceptionResponse();
		response.setErrorMessage(e.getMessage());
		response.setErrorCode("NOT_FOUND");
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoFurnituresFoundException.class)
	public ResponseEntity<ExceptionResponse> handleNoFurnitureFoundException(NoFurnituresFoundException e){
		ExceptionResponse response=new ExceptionResponse();
		response.setErrorMessage(e.getMessage());
		response.setErrorCode("NOT_FOUND");
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
