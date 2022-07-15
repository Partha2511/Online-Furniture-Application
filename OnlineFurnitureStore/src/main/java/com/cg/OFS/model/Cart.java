package com.cg.OFS.model;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "cart_tbl")
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CartId")
	private int cartId;
//	@Column(name = "OrderId")
//	private String orderId;
	@JsonIgnore
	@OneToOne(mappedBy= "cart")
    private Customer customer;
	

	
	@ManyToMany
	@JoinTable(name="cart_furniture"
	,joinColumns= {@JoinColumn(name="card_id")}
	,inverseJoinColumns= {@JoinColumn(name="furniture_id")})
	private List<Furniture> furnitures = new ArrayList<Furniture>();
	
	@Column(name = "Quantity")
    private int quantity;
	
	public Cart() {
		
	}

	public Cart(int cartId, int quantity) {
		super();
		this.cartId = cartId;
		//this.orderId = orderId;
		this.quantity = quantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Furniture> getFurnitures() {
		return furnitures;
	}

	public void setFurnitures(List<Furniture> furnitures) {
		this.furnitures = furnitures;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

//	public String getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(String orderId) {
//		this.orderId = orderId;
//	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
