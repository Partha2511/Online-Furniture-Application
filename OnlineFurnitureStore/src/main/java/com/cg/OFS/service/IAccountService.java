package com.cg.OFS.service;

import java.util.List;

import com.cg.OFS.model.Account;

public interface IAccountService {
	public Account addAccount(int userId,Account account);
	public Account updateAccount(int userId,Account account);
	public Account deleteAccount(int userId,Account account);
	public List<Account> getAccounts(int userId);
}
