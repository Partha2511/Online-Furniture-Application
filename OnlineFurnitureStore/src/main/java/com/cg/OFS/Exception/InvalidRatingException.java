package com.cg.OFS.Exception;

@SuppressWarnings("serial")
public class InvalidRatingException extends Exception{
	public InvalidRatingException() {
		
	}
	public InvalidRatingException(String message) {
		super(message);
	}

}
