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

import com.cg.OFS.Exception.AddressNotFound;
import com.cg.OFS.Exception.ExceptionResponse;
import com.cg.OFS.model.Address;
import com.cg.OFS.service.AddressServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/addressManagement")
public class AddressController {
	
	@Autowired
	public AddressServiceImpl aImpl;
	
	@PostMapping("/address/{userId}")
	public ResponseEntity<Address> addAddress(@PathVariable("userId") int userId,@RequestBody Address address){
		Address savedAddress=aImpl.addAddress(userId, address);
		if(savedAddress!=null){
			return new ResponseEntity<Address>(savedAddress, HttpStatus.OK);
		}
		return null;//change when everyone has uploaded
	}
	
	@PutMapping("/address/{userId}")
	public ResponseEntity<Address> updateAddress(@PathVariable("userId") int userId,@RequestBody Address address) throws AddressNotFound{
		Address updatedAddress=aImpl.updateAddress(userId, address);
		if(updatedAddress!=null){
			return new ResponseEntity<Address>(updatedAddress, HttpStatus.OK);
		}
		throw new AddressNotFound("Sorry this address doesn't exist");
	}
	
	@DeleteMapping("/address/{userId}")
	public ResponseEntity<Address> deleteAddress(@PathVariable("userId") int userId,@RequestBody Address address) throws AddressNotFound{
		Address deletedAddress=aImpl.deleteAddress(userId, address);
		if(deletedAddress!=null){
			return new ResponseEntity<Address>(deletedAddress, HttpStatus.OK);
		}
		throw new AddressNotFound("Sorry this address doesn't exist");
	}
	
	@GetMapping("/address/{userId}")
	public ResponseEntity<List<Address>> getAllAddresss(@PathVariable("userId") int userId) throws AddressNotFound{
		List<Address> listAddress=aImpl.getAllAddresss(userId);
		if(listAddress.size()!=0){
			return new ResponseEntity<List<Address>>(listAddress, HttpStatus.OK);
		}
		throw new AddressNotFound("Sorry No address available");
	}
	
	@ExceptionHandler(AddressNotFound.class)
	public ResponseEntity<ExceptionResponse> handleException(Exception e){
		ExceptionResponse response=new ExceptionResponse();
		response.setErrorMessage(e.getMessage());
		response.setErrorCode("NOT_FOUND");
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
}
