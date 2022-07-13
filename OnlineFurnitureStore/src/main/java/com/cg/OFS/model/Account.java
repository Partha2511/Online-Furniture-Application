package com.cg.OFS.model;

import javax.persistence.*;

@Entity
@Table(name="Account_tbl")
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

	public Account(int accountid, String accountNo, String accountBalance) {
		super();
		this.accountid = accountid;
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
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


	
}
