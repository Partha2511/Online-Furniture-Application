package com.cg.OFS.service;

import java.util.List;

import com.cg.OFS.model.Furniture;

public interface IFurnitureManagementService {

	public List<Furniture> getAllFurnitures();
	public Furniture getFurnitureById(int furnitureId);
	public Furniture registerFurniture(Furniture furniture);
	public Furniture updateFurniture(Furniture furniture);
	public Furniture updateFurnitureById(int furnitureId,Furniture furniture);
	public String deleteFurniture(Furniture furniture);
	public String deleteFurnitureById(int furnitureId);

	
}
