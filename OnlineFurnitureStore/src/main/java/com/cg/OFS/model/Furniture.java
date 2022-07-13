package com.cg.OFS.model;

 

import java.util.ArrayList;
import java.util.List;

 

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

 

 

@Entity
@Table(name = "furniture_tbl")
public class Furniture {
    @Id
    @Column(name = "FurnitureId")
    private long furnitureId;
    @Column(name = "FurnitureName")
    private String furnitureName;
    @Column(name = "FurnitureColor")
    private String furnitureColor;
    @Column(name = "FutureModel")
    private String furnitureModel;
    @Column(name = "Price")
    private double price;
    
    @OneToMany(mappedBy="furniture")
    private List<Review> feedBacks = new ArrayList<Review>();
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="cart_id")
    private Cart cart;
    
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
    

 

}
 