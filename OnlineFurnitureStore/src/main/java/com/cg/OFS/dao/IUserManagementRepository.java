package com.cg.OFS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.OFS.model.Customer;

@Repository
public interface IUserManagementRepository extends JpaRepository<Customer,Integer>{

}
