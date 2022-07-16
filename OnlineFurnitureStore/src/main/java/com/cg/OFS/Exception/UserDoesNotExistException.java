package com.cg.OFS.Exception;

public class UserDoesNotExistException extends RuntimeException{

	public UserDoesNotExistException(String msg) {
		super(msg);
	}
}
