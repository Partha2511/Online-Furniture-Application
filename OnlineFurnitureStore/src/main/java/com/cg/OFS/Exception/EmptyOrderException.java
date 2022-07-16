package com.cg.OFS.Exception;

@SuppressWarnings("serial")
public class EmptyOrderException extends Exception{
	public EmptyOrderException() {
		
	}
	public EmptyOrderException(String message) {
		super(message);
	}
}
