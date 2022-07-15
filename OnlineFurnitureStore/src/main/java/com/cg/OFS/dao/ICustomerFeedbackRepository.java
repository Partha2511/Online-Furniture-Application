package com.cg.OFS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.OFS.model.Review;

@Repository
public interface ICustomerFeedbackRepository extends JpaRepository<Review, Integer>{
	
	
	public List<Review> getReviewByReviewRating(int reviewRating);

}
