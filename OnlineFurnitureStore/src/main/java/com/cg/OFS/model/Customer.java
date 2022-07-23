package com.cg.OFS.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer_tbl")
public class Customer extends User{
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer",fetch=FetchType.EAGER)
	private List<Address> addresses=new ArrayList<Address>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Account> accounts=new ArrayList<Account>();
	@Column(name="Mobile_No", length=30)
	private String mobileNo;
	@Column(name="Email", length=30)
	private String email;
	@OneToOne(cascade=CascadeType.ALL)
	private Cart cart;
	
	@ManyToMany(mappedBy="customers", cascade = CascadeType.ALL)
	private List<Order> orders = new ArrayList<Order>();
	
	@OneToMany(mappedBy = "customer")
	public List<Review> listReviews = new ArrayList<Review>();
	
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Customer() {
		super();
	}

//	public Customer(int uid, String username, String password, String role,String mobileNo, String email) {
//		super(uid,username,password,role);
//		this.mobileNo = mobileNo;
//		this.email = email;
//	}

	public List<Review> getListReviews() {
		return listReviews;
	}

	public void setListReviews(List<Review> listReviews) {
		this.listReviews = listReviews;
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
