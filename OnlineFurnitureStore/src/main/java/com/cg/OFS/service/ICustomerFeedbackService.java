package com.cg.OFS.service;

import java.util.List;

import com.cg.OFS.model.Review;

public interface ICustomerFeedbackService {
	public List<Review> getAllReviews();
	public List<Review> getReviewByreviewRating(int reviewRating);

}