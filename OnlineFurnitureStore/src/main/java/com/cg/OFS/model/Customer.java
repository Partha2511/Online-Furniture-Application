package com.cg.OFS.model;

import java.util.ArrayList;
import java.util.List;

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
	private List<Address> addresses=new ArrayList<Address>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Account> accounts=new ArrayList<Account>();
	@Column(name="Mobile No", length=30)
	private String mobileNo;
	@Column(name="Email", length=30)
	private String email;
	@OneToOne
	private Cart cart;
	
	public Customer() {
		super();
	}

	public Customer(int uid, String username, String password, String role,String mobileNo, String email, Review review) {
		super(uid,username,password,role);
		this.mobileNo = mobileNo;
		this.email = email;
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
