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
	@Transactional
	public Furniture registerFurniture(Furniture furniture) {
		return fms.save(furniture);
	}
  
	@Override
	@Transactional
	public Furniture updateFurniture(Furniture furniture) {
		if(getFurnitureById(furniture.getFurnitureId())!=null){
			return fms.save(furniture);
		}
		return null;
	}

	@Override
	@Transactional
	public Furniture updateFurnitureById(long furnitureId,Furniture furniture) {
		if(getFurnitureById(furnitureId)==null){
			return null;
		}
		return fms.save(furniture);
	}

	@Override
	@Transactional
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
		System.out.println(delFurniture);
		if(delFurniture==null){
			return null;
		}
//		for(Cart c:delFurniture.getCarts()) {
//			List<Furniture> lf =c.getFurnitures();
//			List<Furniture> nf = new ArrayList<Furniture>();
//			for(Furniture f:lf) {
//				if(f.getFurnitureId()==furnitureId) {
//					nf.add(f);
//				}
//			}
//			c.setFurnitures(nf);
//			cRepo.save(c);
//		}
		delFurniture.setCarts(null);
		
		
		fms.save(delFurniture);
		fms.deleteFurnitureByFurnitureId(furnitureId);
		return delFurniture.getFurnitureName();
	}

}
