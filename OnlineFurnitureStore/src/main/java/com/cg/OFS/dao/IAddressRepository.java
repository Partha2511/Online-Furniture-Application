package com.cg.OFS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.OFS.model.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {

}
