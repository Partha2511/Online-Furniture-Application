package com.cg.OFS.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.OFS.model.Card;

public interface ICardRepository extends JpaRepository<Card,Integer> {

}
