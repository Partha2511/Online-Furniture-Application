package com.cg.OFS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.OFS.dao.IFurnitureRepository;
import com.cg.OFS.model.Furniture;

@Service
public class FurnitureManagementImpl implements IFurnitureManagementService {
	
	@Autowired
	private IFurnitureRepository fms;

	@Override
	public List<Furniture> getAllFurnitures() {
		return fms.findAll();
	}

	@Override
	public Furniture getFurnitureById(int furnitureId) {
		if(fms.findById(furnitureId).get()==null){
			return null;
		}
		return fms.findById(furnitureId).get();
	}

	@Override
	public Furniture registerFurniture(Furniture furniture) {
		return fms.save(furniture);
	}

	@Override
	public Furniture updateFurniture(Furniture furniture) {
		if(fms.findById((int) furniture.getFurnitureId()).get()!=null){
			return fms.save(furniture);
		}
		return null;
	}

	@Override
	public Furniture updateFurnitureById(int furnitureId,Furniture furniture) {
		if(getFurnitureById(furnitureId)==null){
			return null;
		}
		return fms.save(furniture);
	}

	@Override
	public String deleteFurniture(Furniture furniture) {
		Furniture delFurniture=fms.findById((int)furniture.getFurnitureId()).get();
		if(delFurniture==null){
			return null;
		}
		fms.delete(furniture);
		return delFurniture.getFurnitureName();
	}

	@Override
	public String deleteFurnitureById(int furnitureId) {
		Furniture delFurniture=fms.findById(furnitureId).get();
		if(delFurniture==null){
			return null;
		}
		fms.deleteById(furnitureId);
		return delFurniture.getFurnitureName();
	}

}
