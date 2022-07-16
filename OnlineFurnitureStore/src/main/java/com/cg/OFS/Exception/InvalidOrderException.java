package com.cg.OFS.Exception;

@SuppressWarnings("serial")
public class InvalidOrderException extends Exception{
	public InvalidOrderException() {
		
	}
	public InvalidOrderException(String message) {
		super(message);
	}
}
