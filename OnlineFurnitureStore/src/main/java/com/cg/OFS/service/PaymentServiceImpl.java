package com.cg.OFS.service;

import com.cg.OFS.dao.IPaymentRepository;
import com.cg.OFS.model.Bill;
import com.cg.OFS.model.Card;

public class PaymentServiceImpl implements IPaymentService{
	
	IPaymentRepository paymentRepo;

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
		return 0;
	}

	@Override
	public Card payByCard(Card card) {
		// TODO Auto-generated method stub
		return null;
	}

}
