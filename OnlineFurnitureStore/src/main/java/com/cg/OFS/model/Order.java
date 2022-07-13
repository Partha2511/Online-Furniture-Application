package com.cg.OFS.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "order_tbl")

public class Order {
	@Id
	@Column(name = "Id")
	private String orderId;
	
	@Column(name = "OrderDate")
	private Date orderDate;
	
	@Column(name = "Furniture")
	private Furniture furniture;
	
	@ManyToOne
	@Column(name = "Customer")
	private Customer customer;
	
	@Column(name = "Quanity")
	private int quanity;
	
	@Column(name = "Price")
	private double price;
	
	@Column(name = "Amount")
	private double amount;
	
	@Column(name = "Status")
	private String status;
	
	@OneToOne
	private Card card;

	
	public 	Order() {
		
	}
	

	public Order(String orderId, Date orderDate, Furniture furniture, Customer customer, int quanity, double price,
			double amount, String status, Card card) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.furniture = furniture;
		this.customer = customer;
		this.quanity = quanity;
		this.price = price;
		this.amount = amount;
		this.status = status;
		this.card = card;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public Furniture getFurniture() {
		return furniture;
	}


	public void setFurniture(Furniture furniture) {
		this.furniture = furniture;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public int getQuanity() {
		return quanity;
	}


	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Card getCard() {
		return card;
	}


	public void setCard(Card card) {
		this.card = card;
	}
	
	
	
	
	
}
