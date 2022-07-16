package com.cg.OFS.Exception;

@SuppressWarnings("serial")
public class InvalidOrderByIdException extends Exception{
	public InvalidOrderByIdException() {
		
	}
	public InvalidOrderByIdException(String message) {
		super(message);
	}
}
