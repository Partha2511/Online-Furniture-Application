package com.cg.OFS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="acnt_tbl")
public class Account {
	
	@Id
	private int accountid;
	@Column(name="Account Number", length=30)
	private String accountNo;
	@Column(name="Account Balance", length=30)
	private String accountBalance;
	@ManyToOne
	private Customer customer;
	@OneToOne
	private Card card;
	
	public Account() {
		super();
	}

	

	public Account(int accountid, String accountNo, String accountBalance, Customer customer, Card card) {
		super();
		this.accountid = accountid;
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
		this.customer = customer;
		this.card = card;
	}



	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	
}
