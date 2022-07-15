package com.cg.OFS.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OFS.model.Bill;
import com.cg.OFS.model.Card;
import com.cg.OFS.service.PaymentServiceImpl;

@RestController
public class PaymentController {
	@Autowired
	PaymentServiceImpl pserv;
	
	@GetMapping("/getBillById/{billNo}")
	public ResponseEntity<Bill> getBillById(@PathVariable("billNo") long billNo) throws Exception{
		Bill  bill=pserv.getBillById(billNo);
		if(bill==null){
			throw new Exception("This bill number does not exists.");
		}
		return new ResponseEntity<Bill>(bill,HttpStatus.OK);
	}
	
	

	public ResponseEntity<Double> payByCash(@PathVariable("amount")double amount) {
		Double d = pserv.payByCash(amount);
		return new ResponseEntity<Double>(d,HttpStatus.OK);
	}
	
	public ResponseEntity<Card> payByCard(Card card, @PathVariable("amount")double amount)  throws Exception{
		
		Card cards = pserv.payByCard(card, amount);
		if(cards==null) {
			throw new Exception("This card does not exists.");
		}
		return new ResponseEntity<Card>(cards,HttpStatus.OK);
	}

	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

}
