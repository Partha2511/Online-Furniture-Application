package com.cg.OFS.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.OFS.model.Review;
import com.cg.OFS.service.CustomerFeedbackServiceImp;
@SpringBootTest
class CustomerFeedbackTest {
	@Autowired
	private CustomerFeedbackServiceImp impl;

	@Test
	void testAddReview() {
		Review review=new Review();
		review.setReviewRating(4);
		review.setDescription("Good");
		Review result=impl.addReview(4, 100, review);
		assertEquals(null, result);
	}
	
	@Test
	void testGetAllReviews() {
		assertTrue(impl.getAllReviews().size()!=0);
	}

}
