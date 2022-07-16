package com.cg.OFS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.OFS.dao.IAddressRepository;
import com.cg.OFS.dao.ICustomerRepository;
import com.cg.OFS.model.Address;
import com.cg.OFS.model.Customer;

public class AddressServiceImpl implements IAddressService{

	@Autowired
	public ICustomerRepository cRepo;
	@Autowired
	public IAddressRepository aRepo;
	
	@Override
	public Address addAddress(int userId, Address address) {
		if(cRepo.existsById(userId)){
			Customer c=cRepo.findById(userId).get();
			c.getAddresses().add(address);
			cRepo.save(c);
			return address;
		}
		return null;
	}

	@Override
	public Address updateAddress(int userId, Address address) {
		if(cRepo.existsById(userId)){
			Customer c=cRepo.findById(userId).get();
			if(aRepo.existsById(address.getAid())){
				address.setCustomer(c);
				aRepo.save(address);
				return address;
			}
			return null;
		}
		return null;
	}

	@Override
	public Address deleteAddress(int userId, Address address) {
		if(cRepo.existsById(userId)){
			if(aRepo.existsById(address.getAid())){
				address.setCustomer(null);
				aRepo.save(address);
				aRepo.delete(address);
				return address;
			}
			return null;
		}
		return null;
	}

	@Override
	public List<Address> getAllAddresss(int userId) {
		if(cRepo.existsById(userId)){
			Customer c=cRepo.findById(userId).get();
			if(c.getAddresses().size()!=0){
				return c.getAddresses();
			}
			return null;
		}
		return null;
	}

}
