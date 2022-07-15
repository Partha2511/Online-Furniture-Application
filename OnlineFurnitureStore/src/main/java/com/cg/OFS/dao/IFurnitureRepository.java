package com.cg.OFS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.OFS.model.Furniture;

@Repository
public interface IFurnitureRepository extends JpaRepository<Furniture, Integer> {

	public Furniture getFurnitureByFurnitureId(long furnitureId);
	
	
	public String deleteFurnitureByFurnitureId(long furnitureId);
}
