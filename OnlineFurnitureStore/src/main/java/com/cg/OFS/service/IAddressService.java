package com.cg.OFS.service;

import java.util.List;

import com.cg.OFS.model.Address;

public interface IAddressService {
	public Address addAddress(int userId,Address address);
	public Address updateAddress(int userId,Address address);
	public Address deleteAddress(int userId,int aid);
	public List<Address> getAllAddresss(int userId);
}
