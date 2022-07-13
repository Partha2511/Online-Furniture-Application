package com.cg.OFS.model;

import javax.persistence.*;

@Entity
@Table(name="Address_tbl")
public class Address {
	@Id
	private int Aid;
	@Column(name="City", length=30)
	private String city;
	@Column(name="State", length=30)
	private String state;
	@Column(name="Country", length=30)
	private String country;
	@Column(name="Pincode", length=30)
	private String pincode;
	@ManyToOne
	private Customer customer;
	
	public Address() {
		super();
	}

	public Address(int aid, String city, String state, String country, String pincode) {
		super();
		Aid = aid;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public int getAid() {
		return Aid;
	}

	public void setAid(int aid) {
		Aid = aid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
