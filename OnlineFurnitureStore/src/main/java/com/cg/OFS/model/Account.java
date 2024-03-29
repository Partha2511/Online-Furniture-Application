package com.cg.OFS.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="acnt_tbl")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int accountid;
	@Column(name="Account_Number", length=30)
	private String accountNo;
	@Column(name="Account_Balance", length=30)
	private String accountBalance;
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	private Customer customer;
	@OneToOne(cascade=CascadeType.ALL)
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
