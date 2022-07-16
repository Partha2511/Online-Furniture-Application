package com.cg.OFS.contoller;

import java.time.LocalDateTime;
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

import com.cg.OFS.Exception.AccountNotFound;
import com.cg.OFS.Exception.ExceptionResponse;
import com.cg.OFS.model.Account;
import com.cg.OFS.service.AccountServiceImpl;

@RestController
@RequestMapping("/accountManagement")
public class AccountController {
	
	@Autowired
	public AccountServiceImpl aimpl;
	
	@PostMapping("/account/{userId}")
	public ResponseEntity<Account> addAccount(@PathVariable("userId")int userId,@RequestBody Account account) {
		Account savedAccount= aimpl.addAccount(userId, account);
		if(savedAccount!=null){
			return new ResponseEntity<Account>(savedAccount,HttpStatus.OK);
		}
		return null;
	}
	
	@PutMapping("/account/{userId}")
	public ResponseEntity<Account> updateAccount(@PathVariable("userId")int userId,@RequestBody Account account) throws AccountNotFound{
		Account updatedAccount=aimpl.updateAccount(userId, account);
		if(updatedAccount!=null){
			return new ResponseEntity<Account>(updatedAccount,HttpStatus.OK);
		}
		throw new AccountNotFound("Sorry this account doesn't exist");
	}
	
	@DeleteMapping("/account/{userId}")
	public ResponseEntity<Account> deleteAccount(@PathVariable("userId")int userId,@RequestBody Account account) throws AccountNotFound{
		Account deletedAccount=aimpl.deleteAccount(userId, account);
		if(deletedAccount!=null){
			return new ResponseEntity<Account>(deletedAccount,HttpStatus.OK);
		}
		throw new AccountNotFound("Sorry this account doesn't exist");
	}
	
	@GetMapping("/account/{userId}")
	public ResponseEntity<List<Account>> getAccounts(@PathVariable("userId")int userId) throws AccountNotFound{
		List<Account> listAccount=aimpl.getAccounts(userId);
		if(listAccount.size()!=0){
			return new ResponseEntity<List<Account>>(listAccount,HttpStatus.OK);
		}
		throw new AccountNotFound("Sorry No Accounts Found");
	}
	
	@ExceptionHandler(AccountNotFound.class)
	public ResponseEntity<ExceptionResponse> handleException(Exception e){
		ExceptionResponse response=new ExceptionResponse();
		response.setErrorMessage(e.getMessage());
		response.setErrorCode("NOT_FOUND");
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
}
