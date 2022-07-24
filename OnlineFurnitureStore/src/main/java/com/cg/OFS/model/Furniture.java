package com.cg.OFS.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "furniture_tbl")
public class Furniture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FurnitureId")
	private long furnitureId;
	// @NotBlank(message = "Furniture Name is mandatory")
	@Column(name = "FurnitureName")
	private String furnitureName;
	// @NotBlank(message = "Furniture Color is mandatory")
	@Column(name = "FurnitureColor")
	private String furnitureColor;
	// @NotBlank(message = "Furniture Model is mandatory")
	@Column(name = "FutureModel")
	private String furnitureModel;
	// @NotBlank(message = "Price is mandatory")
	@Column(name = "Price")
	private double price;
	// @NotBlank(message = "Image url is mandatory")
	@Column(name = "ImgUrl")
	private String imgUrl;

	@OneToMany(mappedBy = "furniture", cascade = CascadeType.ALL)
	private List<Review> feedBacks = new ArrayList<Review>();

	@JsonIgnore
	@ManyToMany(mappedBy = "furnitures", cascade = CascadeType.ALL)
	private List<Cart> carts = new ArrayList<Cart>();

	public Furniture() {

	}

	public Furniture(long furnitureId, String furnitureName, String furnitureColor, String furnitureModel,
			double price) {
		super();
		this.furnitureId = furnitureId;
		this.furnitureName = furnitureName;
		this.furnitureColor = furnitureColor;
		this.furnitureModel = furnitureModel;
		this.price = price;
	}

	public long getFurnitureId() {
		return furnitureId;
	}

	public void setFurnitureId(long furnitureId) {
		this.furnitureId = furnitureId;
	}

	public String getFurnitureName() {
		return furnitureName;
	}

	public void setFurnitureName(String furnitureName) {
		this.furnitureName = furnitureName;
	}

	public String getFurnitureColor() {
		return furnitureColor;
	}

	public void setFurnitureColor(String furnitureColor) {
		this.furnitureColor = furnitureColor;
	}

	public String getFurnitureModel() {
		return furnitureModel;
	}

	public void setFurnitureModel(String furnitureModel) {
		this.furnitureModel = furnitureModel;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Review> getFeedBacks() {
		return feedBacks;
	}

	public void setFeedBacks(List<Review> feedBacks) {
		this.feedBacks = feedBacks;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
