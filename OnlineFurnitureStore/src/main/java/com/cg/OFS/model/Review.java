package com.cg.OFS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="review_tbl")
public class Review {
	@Id
	@Column(name="review_id")
	private int reviewId;
	@Column(name="description")
	private String description;
	@Column(name="review_rating")
	private int reviewRating;
	
	@ManyToOne
	private Furniture furniture;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}
	
	public Review(int reviewId, String description, int reviewRating) {
		this.reviewId = reviewId;
		this.description = description;
		this.reviewRating = reviewRating;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReviewRating() {
		return reviewRating;
	}

	public void setReviewRating(int reviewRating) {
		this.reviewRating = reviewRating;
	}
	
}
