package com.cg.OFS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.OFS.dao.IAccountRepository;
import com.cg.OFS.dao.ICustomerRepository;
import com.cg.OFS.model.Account;
import com.cg.OFS.model.Customer;

public class AccountServiceImpl implements IAccountService{

	@Autowired
	public ICustomerRepository cRepo;
	@Autowired
	public IAccountRepository aRepo;
	
	@Override
	public Account addAccount(int userId, Account account) {
		if(cRepo.existsById(userId)){
			Customer c=cRepo.findById(userId).get();
			c.getAccounts().add(account);
			cRepo.save(c);
			return account;
		}
		return null;
	}

	@Override
	public Account updateAccount(int userId, Account account) {
		if(cRepo.existsById(userId)){
			Customer c=cRepo.findById(userId).get();
			if(aRepo.existsById(account.getAccountid())){
				account.setCustomer(c);
				aRepo.save(account);
				return account;
			}
			return null;
		}
		return null;
	}

	@Override
	public Account deleteAccount(int userId, Account account) {
		if(cRepo.existsById(userId)){
			if(aRepo.existsById(account.getAccountid())){
				account.setCustomer(null);
				aRepo.save(account);
				aRepo.delete(account);
				return account;
			}
			return null;
		}
		return null;
	}

	@Override
	public List<Account> getAccounts(int userId) {
		if(cRepo.existsById(userId)){
			Customer c=cRepo.findById(userId).get();
			if(c.getAccounts().size()!=0){
				return c.getAccounts();
			}
			return null;
		}
		return null;
	}

}
