package com.cg.OFS.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "order_tbl")

public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private Integer orderId;
	
	@Column(name = "OrderDate")
	private LocalDate orderDate;
	
//	@Column(name = "Furniture")
//	private Furniture furniture;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="cust_order"
	,joinColumns= {@JoinColumn(name="order_id")}
	,inverseJoinColumns= {@JoinColumn(name="cust_id")})
	private List<Customer> customers= new ArrayList<Customer>();
	
	@Column(name = "Quantity")
	private int quantity;
	
	@Column(name = "Price")
	private double price;
	
	
	@Column(name = "Status")
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Bill bill;

	
	public 	Order() {
		
	}
	

	public Order(Integer orderId, LocalDate orderDate, int quantity, double price
			, String status) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		//this.furniture = furniture;
//		this.customer = customer;
		this.quantity = quantity;
		this.price = price;
		
		this.status = status;
	}


	public Integer getOrderId() {
		return orderId;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	public LocalDate getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}


//	public Furniture getFurniture() {
//		return furniture;
//	}
//
//
//	public void setFurniture(Furniture furniture) {
//		this.furniture = furniture;
//	}





	public int getQuantity() {
		return quantity;
	}


	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	public Bill getBill() {
		return bill;
	}


	public void setBill(Bill bill) {
		this.bill = bill;
	}


	public void setQuantity(int quanity) {
		this.quantity = quanity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


//	public double getAmount() {
//		return amount;
//	}
//
//
//	public void setAmount(double amount) {
//		this.amount = amount;
//	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}	
	
}
