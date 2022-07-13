package com.cg.OFS.model;

import javax.persistence.*;

@Entity
@Table(name="Review_tbl")
public class Review {
	
	@Id
	private int reviewId;
	@Column(name="Description", length=30)
	private String description;
	@Column(name="Review Ratng", length=30)
	private int reviewRating;
	
	public Review() {
		super();
	}

	public Review(int reviewId, String description, int reviewRating) {
		super();
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

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", description=" + description + ", reviewRating=" + reviewRating + "]";
	}

}
