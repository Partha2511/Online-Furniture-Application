package com.cg.OFS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.OFS.dao.IUserManagementRepository;
import com.cg.OFS.model.Customer;

@Service
public class UserManagementServiceImpl implements IUserManagementService {

	@Autowired
	IUserManagementRepository userRepo;

	@Override
	public boolean loginUser(String username, String password) {
		List<Customer> users = userRepo.findAll();
		for (Customer u : users) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
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
		if (userRepo.existsById(Customer.getUid())) {
			Customer c = userRepo.findById(Customer.getUid()).get();
			Customer.getCart().setFurnitures(c.getCart().getFurnitures());
			Customer.setOrders(c.getOrders());
			Customer.setListReviews(c.getListReviews());
			Customer.setAddresses(c.getAddresses());
			Customer.setAccounts(c.getAccounts());
			return userRepo.save(Customer);

		}
		return null;
	}

	@Override
	public String deleteUser(Customer customer) {
		if (userRepo.existsById(customer.getUid())) {
			Customer delUser = userRepo.findById((int) customer.getUid()).get();
			delUser.getCart().setFurnitures(null);
			userRepo.save(delUser);
			userRepo.delete(customer);
			return delUser.getUsername();
		}
		return null;
	}

	@Override
	public String deleteUserById(int uid) {
		if (userRepo.existsById(uid)) {
			Customer delUser = userRepo.findById(uid).get();
			delUser.getCart().setFurnitures(null);
			userRepo.save(delUser);
			userRepo.delete(delUser);
			return delUser.getUsername();
		}
		return null;
	}
}
