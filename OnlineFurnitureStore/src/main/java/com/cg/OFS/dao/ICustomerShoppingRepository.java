package com.cg.OFS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.OFS.model.Furniture;

@Repository
public interface ICustomerShoppingRepository  extends JpaRepository<Furniture,Long>{
	
	
	public Furniture getFurnitureByFurnitureName(String furnitureName);


}
