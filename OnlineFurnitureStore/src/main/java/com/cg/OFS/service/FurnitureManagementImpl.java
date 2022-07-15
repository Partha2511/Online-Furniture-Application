package com.cg.OFS.service;

import java.util.List;

import javax.transaction.Transactional;

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
	public Furniture getFurnitureById(long furnitureId) {
		Furniture f = fms.getFurnitureByFurnitureId(furnitureId);
		if(f==null){
			return null;
		}
		return f;
	}

	@Override
	public Furniture registerFurniture(Furniture furniture) {
		return fms.save(furniture);
	}

	@Override
	public Furniture updateFurniture(Furniture furniture) {
		if(getFurnitureById(furniture.getFurnitureId())!=null){
			return fms.save(furniture);
		}
		return null;
	}

	@Override
	public Furniture updateFurnitureById(long furnitureId,Furniture furniture) {
		if(getFurnitureById(furnitureId)==null){
			return null;
		}
		return fms.save(furniture);
	}

	@Override
	public String deleteFurniture(Furniture furniture) {
		Furniture delFurniture=getFurnitureById(furniture.getFurnitureId());
		if(delFurniture==null){
			return null;
		}
		fms.delete(furniture);
		return delFurniture.getFurnitureName();
	}

	@Override
	@Transactional
	public String deleteFurnitureById(long furnitureId) {
		Furniture delFurniture=getFurnitureById(furnitureId);
		if(delFurniture==null){
			return null;
		}
		fms.deleteFurnitureByFurnitureId(furnitureId);
		return delFurniture.getFurnitureName();
	}

}
