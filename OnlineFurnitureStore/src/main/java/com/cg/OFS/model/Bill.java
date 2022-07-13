package com.cg.OFS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Bill_tbl")
public class Bill {
	
	@Id
	@Column(name="BillNo")
	private long billNo;
	
	@Column(name="Customer_Name")
	private String customerName;
	
	//private Furniture furniture;
	
	@Column(name="Quantity")
	private int quanity;
	
	@Column(name="Price")
    private double price;
	
	@Column(name="Amount")
    private double amount;
	
	@OneToOne
	private Order order;
	
	public Bill() {
		super();
	}
	
	public Bill(long billNo, String customerName, int quanity, double price, double amount, Order order) {
		super();
		this.billNo = billNo;
		this.customerName = customerName;
		this.quanity = quanity;
		this.price = price;
		this.amount = amount;
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
    
    
    

}
