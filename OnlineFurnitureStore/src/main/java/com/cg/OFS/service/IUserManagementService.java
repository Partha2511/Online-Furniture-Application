package com.cg.OFS.service;

import com.cg.OFS.model.Customer;

public interface IUserManagementService {
	
	public Customer loginUser(String username,String password,String role);
	public Customer registerNewUser(Customer Customer);
	public Customer updateUser(Customer Customer);
	public String deleteUser(Customer Customer);
	public String deleteUserById(int uid);
}
