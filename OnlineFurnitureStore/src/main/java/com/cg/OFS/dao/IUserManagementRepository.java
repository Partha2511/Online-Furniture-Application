package com.cg.OFS.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.OFS.model.Customer;


public interface IUserManagementRepository extends JpaRepository<Customer,Integer>{

}
