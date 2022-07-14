package com.cg.OFS.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	public ResponseEntity<List<Review>> getAllReviews() throws Exception {
		List<Review> reviews= impl.getAllReviews();
		if(reviews.isEmpty()) {
			throw new Exception("Sorry! Reviews not Found");
		}
		return new ResponseEntity<List<Review>>(reviews,HttpStatus.OK);
	}
	
	@GetMapping("/getReviewByreviewRating")
	public int getReviewByreviewRating(int reviewRating) throws Exception{
		return reviewRating;
		
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
