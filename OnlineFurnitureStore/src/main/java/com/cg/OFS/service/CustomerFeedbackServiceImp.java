package com.cg.OFS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.OFS.dao.ICustomerFeedbackRepository;
import com.cg.OFS.dao.IFurnitureRepository;
import com.cg.OFS.dao.IUserManagementRepository;
import com.cg.OFS.model.Customer;
import com.cg.OFS.model.Furniture;
import com.cg.OFS.model.Review;

@Service
public class CustomerFeedbackServiceImp implements ICustomerFeedbackService{
	@Autowired
	ICustomerFeedbackRepository repo;
	@Autowired
	IFurnitureRepository frepo;
	@Autowired
	IUserManagementRepository uRepo;


	public Review addReview(long furnitureId,int customerId,Review review){
		Customer customer = uRepo.findById(customerId).get();
		Furniture f = frepo.getFurnitureByFurnitureId(furnitureId);
		review.setCustomer(customer);
		review.setFurniture(f);
		f.getFeedBacks().add(review);
		frepo.save(f);
		customer.getListReviews().add(review);
		uRepo.save(customer);
		return review;
	}
	
		
	@Override
	public List<Review> getAllReviews() {
		List<Review> orders= repo.findAll();
		return orders;
	}

	@Override
	public List<Review> getReviewByreviewRating(int reviewRating) {
		List<Review> reviewByreviewRating = repo.getReviewByReviewRating(reviewRating);
		return reviewByreviewRating.size()==0?null:reviewByreviewRating;

	}

}
