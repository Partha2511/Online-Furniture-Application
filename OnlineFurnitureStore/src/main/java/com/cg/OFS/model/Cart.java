package com.cg.OFS.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_tbl")
public class Cart {
	@Id
	@Column(name = "CartId")
	private int cartId;
	@Column(name = "CartName")
	private String orderId;
	
	@OneToOne(mappedBy="cart")
    private Customer customer;
	
	@OneToMany(mappedBy="cart",cascade=CascadeType.ALL)
	private List<Furniture> furnitures = new ArrayList<Furniture>();
	
	@Column(name = "Quantity")
    private int quantity;
	
	public Cart() {
		
	}

	public Cart(int cartId, String orderId, int quantity) {
		super();
		this.cartId = cartId;
		this.orderId = orderId;
		this.quantity = quantity;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
