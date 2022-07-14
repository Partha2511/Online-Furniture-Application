package com.cg.OFS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.OFS.dao.ICustomerFeedbackRepository;
import com.cg.OFS.model.Review;

@Service
public class CustomerFeedbackServiceImp implements ICustomerFeedbackService{
	@Autowired
	ICustomerFeedbackRepository repo;


	@Override
	public List<Review> getAllReviews() {
		List<Review> orders= repo.findAll();
		return orders;
	}

	@Override
	public int getReviewByreviewRating(int reviewRating) {
		return repo.getReviewByreviewRating(reviewRating);

	}

}
