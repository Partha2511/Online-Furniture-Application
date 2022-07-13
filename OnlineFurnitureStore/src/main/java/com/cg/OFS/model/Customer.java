package com.cg.OFS.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Customer_tbl")
public class Customer extends User{
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private Address address;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private Account account;
	@Column(name="Mobile No", length=30)
	private String mobileNo;
	@Column(name="Email", length=30)
	private String email;
	
	public Customer() {
		super();
	}

	public Customer(Address address, Account account, String mobileNo, String email, Review review) {
		super();
		this.address = address;
		this.account = account;
		this.mobileNo = mobileNo;
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
