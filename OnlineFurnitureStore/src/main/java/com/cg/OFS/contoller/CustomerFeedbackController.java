package com.cg.OFS.contoller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OFS.Exception.ExceptionResponse;
import com.cg.OFS.Exception.InvalidRatingException;
import com.cg.OFS.Exception.NoReviewException;
import com.cg.OFS.model.Review;
import com.cg.OFS.service.CustomerFeedbackServiceImp;

@RestController
@RequestMapping("/customerfeedbackcontroller")
@CrossOrigin("*")
public class CustomerFeedbackController {
	
	@Autowired
	CustomerFeedbackServiceImp impl;
	
	@PostMapping("/addReview/{furnitureId}/{customerId}")
	public ResponseEntity<Review> addReview(@PathVariable("furnitureId")long furnitureId,
			@PathVariable("customerId")int customerId,@RequestBody Review review){
		Review r = impl.addReview(furnitureId, customerId, review);
		return new ResponseEntity<Review>(r ,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/getAllReviews")
	public ResponseEntity<List<Review>> getAllReviews() throws Exception {
		List<Review> reviews= impl.getAllReviews();
		if(reviews.isEmpty()) {
			throw new NoReviewException("Sorry! Reviews not Found");
			
		}
		return new ResponseEntity<List<Review>>(reviews,HttpStatus.OK);
	}
	
	@GetMapping("/getReviewByreviewRating/{reviewRating}")
	public ResponseEntity<List<Review>> getReviewByreviewRating(@PathVariable("reviewRating")int reviewRating) throws Exception{
		List<Review> list = impl.getReviewByreviewRating(reviewRating);
		if(list==null){
			throw new InvalidRatingException("Sorry! Reviews not Found with this rating!!");
		}
		return new ResponseEntity<List<Review>>(list,HttpStatus.OK);
	}
	@ExceptionHandler(NoReviewException.class)
	public ResponseEntity<ExceptionResponse> handlNoReviewException(NoReviewException e) {
		ExceptionResponse response=new ExceptionResponse();
        response.setErrorCode("Not Found");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(InvalidRatingException.class)
	public ResponseEntity<ExceptionResponse> handlNoReviewException(InvalidRatingException e) {
		ExceptionResponse response=new ExceptionResponse();
        response.setErrorCode("Not Found");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
