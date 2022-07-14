package com.cg.OFS.service;

import com.cg.OFS.model.Bill;
import com.cg.OFS.model.Card;

public interface IPaymentService {
	
	Bill getBillById(long billNo);
	double payByCash(double amount);
	Card payByCard(Card card);

}
