package com.cg.OFS.Exception;

@SuppressWarnings("serial")
public class InvalidStatusException extends Exception{
	public InvalidStatusException(){
		
	}
	public InvalidStatusException(String message) {
		super(message);
	}
}
