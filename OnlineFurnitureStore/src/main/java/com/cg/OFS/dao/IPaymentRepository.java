package com.cg.OFS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.OFS.model.Bill;
import com.cg.OFS.model.Card;
@Repository
public interface IPaymentRepository extends JpaRepository<Bill,Long>{
	
	double payByCash(double amount);
	Card payByCard(Card card);

}
