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
@Table(name="Card_tbl")
public class Card {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Card_No")
	private int cardNo;
	@JsonIgnore
	@OneToOne(mappedBy="card")
	private Account account;
	
	@Column(name="Card_Name")
	private String cardName;

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	
	
	

}
