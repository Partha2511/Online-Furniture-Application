package com.cg.OFS.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OFS.model.Customer;
import com.cg.OFS.service.UserManagementServiceImpl;

@RestController
@CrossOrigin("*")
public class UserManagementController {

	@Autowired
	UserManagementServiceImpl uImpl;
	
	public ResponseEntity<Boolean> loginUser(String username,String password) throws Exception{
		Boolean result = uImpl.loginUser(username, password);
		if(result) {
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
		}
		throw new Exception("Incorrect Username and Password !!!");
		
	}
	
	@PostMapping("/Customer/new")
	public ResponseEntity<Customer> registerNewUser(@RequestBody Customer Customer) throws Exception{
		Customer savedUser=uImpl.registerNewUser(Customer);
		if(savedUser==null){
			throw new Exception("Customer Cannot be Added!");
		}
		return new ResponseEntity<Customer>(savedUser, HttpStatus.OK);
	}
	
	@PutMapping("/Customer/update")
	public ResponseEntity<Customer> updateUser(@RequestBody Customer Customer) throws Exception{
		Customer updatedUser=uImpl.updateUser(Customer);
		if(updatedUser==null){
			throw new Exception("Customer not Found");
		}
		return new ResponseEntity<Customer>(Customer,HttpStatus.OK);
	}
	
	@DeleteMapping("/Customer/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestBody Customer Customer) throws Exception{
		String result=uImpl.deleteUser(Customer);
		if(result==null){
			throw new Exception("Customer doesn't exist!!");
		}
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@DeleteMapping("/Customer/deleteUserById/{uid}")
	public ResponseEntity<String> deleteUserById(@PathVariable("uid") int uid) throws Exception{
		String result=uImpl.deleteUserById(uid);
		if(result==null){
			throw new Exception("Customer doesn't exist!!");
		}
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
