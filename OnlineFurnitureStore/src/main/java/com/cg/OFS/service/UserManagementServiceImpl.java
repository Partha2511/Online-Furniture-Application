package com.cg.OFS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.OFS.dao.IUserManagementRepository;
import com.cg.OFS.model.Customer;

@Service
public class UserManagementServiceImpl implements IUserManagementService{

	@Autowired
	IUserManagementRepository userRepo;
	
	@Override
	public boolean loginUser(String username,String password) {
		List<Customer> users = userRepo.findAll();
		for(Customer u:users) {
			if(u.getUsername().equals(username)&&u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Customer registerNewUser(Customer Customer) {
		userRepo.save(Customer);
		return Customer;
	}
	
	@Override
	public Customer updateUser(Customer Customer) {
		if(userRepo.existsById(Customer.getUid())) {
			userRepo.save(Customer);
		}
		return Customer;
	}
	
	@Override
	public String deleteUser(Customer Customer){
		Customer delUser=userRepo.findById((int)Customer.getUid()).get();
		if(delUser==null){
			return null;
		}
		userRepo.delete(Customer);
		return delUser.getUsername();
	}

	@Override
	public String deleteUserById(int uid){
		Customer delUser=userRepo.findById(uid).get();
		if(delUser==null){
			return null;
		}
		userRepo.deleteById(uid);
		return delUser.getUsername();
	}
}
