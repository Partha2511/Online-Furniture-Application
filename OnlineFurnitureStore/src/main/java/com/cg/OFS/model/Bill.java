package com.cg.OFS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Bill_tbl")
public class Bill {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BillNo")
	private long billNo;
	
	@Column(name="Customer_Name")
	private String customerName;
	
	//private Furniture furniture;
	
	@Column(name="Quantity")
	private int quantity;
	
	@Column(name="Price")
    private double price;
	
	
	@JsonIgnore
	@OneToOne
	private Order order;
	
	public Bill() {
		super();
	}
	
	public Bill(long billNo, String customerName, int quantity, double price, Order order) {
		super();
		this.billNo = billNo;
		this.customerName = customerName;
		this.quantity = quantity;
		this.price = price;
		
		this.order = order;
	}

	public long getBillNo() {
		return billNo;
	}
	public void setBillNo(long billNo) {
		this.billNo = billNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
//	public Furniture getFurniture() {
//		return furniture;
//	}
//	public void setFurniture(Furniture furniture) {
//		this.furniture = furniture;
//	}
	public int getQuantity() {
		return quantity;
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
	
    
    
    

}
