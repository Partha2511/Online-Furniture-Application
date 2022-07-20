package com.cg.OFS.contoller;

import java.time.LocalDateTime;

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
import org.springframework.web.bind.annotation.RestController;

import com.cg.OFS.Exception.ExceptionResponse;
import com.cg.OFS.Exception.IncorrectValueException;
import com.cg.OFS.Exception.UserAlreadyExistsException;
import com.cg.OFS.Exception.UserDoesNotExistException;
import com.cg.OFS.model.Customer;
import com.cg.OFS.service.UserManagementServiceImpl;

@RestController
@CrossOrigin("*")
public class UserManagementController {

	@Autowired
	UserManagementServiceImpl uImpl;
	
	@GetMapping("/validateUser/{username}/{password}/{role}")
	public ResponseEntity<Boolean> loginUser(@PathVariable("username") String username,@PathVariable("password")String password,@PathVariable("role")String role) throws IncorrectValueException{
		Boolean result = uImpl.loginUser(username, password,role);
		if(result) {
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
		}
		throw new IncorrectValueException("Incorrect Username and Password !!!");
		
	}
	
	@PostMapping("/Customer/new")
	public ResponseEntity<Customer> registerNewUser(@RequestBody Customer Customer) throws UserAlreadyExistsException{
		Customer savedUser=uImpl.registerNewUser(Customer);
		if(savedUser==null){
			throw new UserAlreadyExistsException("This User Already Exists with us!");
		}
		return new ResponseEntity<Customer>(savedUser, HttpStatus.OK);
	}
	
	@PutMapping("/Customer/update")
	public ResponseEntity<Customer> updateUser(@RequestBody Customer Customer) throws UserDoesNotExistException{
		Customer updatedUser=uImpl.updateUser(Customer);
		if(updatedUser==null){
			throw new UserDoesNotExistException("Customer not Found");
		}
		return new ResponseEntity<Customer>(Customer,HttpStatus.OK);
	}
	
	@DeleteMapping("/Customer/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestBody Customer Customer) throws UserDoesNotExistException{
		String result=uImpl.deleteUser(Customer);
		if(result==null){
			throw new UserDoesNotExistException("Customer doesn't exist!!");
		}
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@DeleteMapping("/Customer/deleteUserById/{uid}")
	public ResponseEntity<String> deleteUserById(@PathVariable("uid") int uid) throws UserDoesNotExistException{
		String result=uImpl.deleteUserById(uid);
		if(result==null){
			throw new UserDoesNotExistException("Customer doesn't exist!!");
		}
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleException(UserAlreadyExistsException e) {
       ExceptionResponse response=new ExceptionResponse();
       response.setErrorCode("CONFLICT");
      response.setErrorMessage(e.getMessage());
      response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
        
    }
	
	@ExceptionHandler(UserDoesNotExistException.class)
    public ResponseEntity<ExceptionResponse> handleException(UserDoesNotExistException e) {
       ExceptionResponse response=new ExceptionResponse();
       response.setErrorCode("NOT_FOUND");
      response.setErrorMessage(e.getMessage());
      response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
        
    }
	
	@ExceptionHandler(IncorrectValueException.class)
    public ResponseEntity<ExceptionResponse> handleException(IncorrectValueException e) {
       ExceptionResponse response=new ExceptionResponse();
       response.setErrorCode("BAD_REQUEST");
      response.setErrorMessage(e.getMessage());
      response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
        
    }
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleException(Exception e){
//		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//	}
}
