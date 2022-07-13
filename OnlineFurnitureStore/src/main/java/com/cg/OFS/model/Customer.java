package com.cg.OFS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Customer_tbl")
public class Customer extends User{
	
	private Address address;
	private Account account;
	@Column(name="Mobile No", length=30)
	private String mobileNo;
	@Column(name="Email", length=30)
	private String email;
	private Review review;
	
	public Customer() {
		super();
	}

	public Customer(Address address, Account account, String mobileNo, String email, Review review) {
		super();
		this.address = address;
		this.account = account;
		this.mobileNo = mobileNo;
		this.email = email;
		this.review = review;
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

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Customer [address=" + address + ", account=" + account + ", mobileNo=" + mobileNo + ", email=" + email
				+ ", review=" + review + "]";
	}
	
	
}
