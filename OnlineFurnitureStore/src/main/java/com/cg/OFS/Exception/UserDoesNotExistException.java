package com.cg.OFS.Exception;

@SuppressWarnings("serial")
public class UserDoesNotExistException extends RuntimeException{

	public UserDoesNotExistException(String msg) {
		super(msg);
	}
}
