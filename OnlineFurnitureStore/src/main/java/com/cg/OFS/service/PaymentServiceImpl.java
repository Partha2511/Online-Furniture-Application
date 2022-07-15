package com.cg.OFS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.OFS.dao.ICardRepository;
import com.cg.OFS.dao.IPaymentRepository;
import com.cg.OFS.model.Bill;
import com.cg.OFS.model.Card;

@Service
public class PaymentServiceImpl implements IPaymentService{
	
	@Autowired
	IPaymentRepository paymentRepo;
	
	@Autowired
	ICardRepository crepo;
	

	@Override
	public Bill getBillById(long billNo) {
		// TODO Auto-generated method stub
		
		if(paymentRepo.existsById(billNo)){
			paymentRepo.findById(billNo);
		}
		return null;
	}

	@Override
	public double payByCash(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Order amount ="+amount+" placed  successfully");
		return amount;
	}

	@Override
	public Card payByCard(Card card, double amount)  {
		// TODO Auto-generated method stub
		if(crepo.existsById(card.getCardNo())) {
			int parseInt = Integer.parseInt(card.getAccount().getAccountBalance());
			if(parseInt>=amount) {
				
				card.getAccount().setAccountBalance(String.valueOf(parseInt-amount));
				crepo.save(card);
				return card;
			}
			
			
		}
		
		return null;
		
		
		
	}

}
