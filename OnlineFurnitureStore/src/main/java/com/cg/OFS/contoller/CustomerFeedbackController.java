package com.cg.OFS.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OFS.model.Review;
import com.cg.OFS.service.ICustomerFeedbackService;

@RestController
@RequestMapping("/customerfeedbackcontroller")
@CrossOrigin("*")
public class CustomerFeedbackController {
	
	@Autowired
	ICustomerFeedbackService impl;
	
	@GetMapping("/getAllReviews")
	public ResponseEntity<List<Review>> getAllReviews() {
		return impl.getAllReviews();
		
	}
	
	@GetMapping("/getReviewByreviewRating")
	public int getReviewByreviewRating(int reviewRating) {
		return reviewRating;
		
	}
}
