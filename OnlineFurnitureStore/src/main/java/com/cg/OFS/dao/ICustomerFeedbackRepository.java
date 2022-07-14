package com.cg.OFS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.OFS.model.Review;

@Repository
public interface ICustomerFeedbackRepository extends JpaRepository<Review, Integer>{
	@Query("select count(r) from Review r where r.reviewRating =?1")
	public int getReviewByreviewRating(int reviewRating);

}
