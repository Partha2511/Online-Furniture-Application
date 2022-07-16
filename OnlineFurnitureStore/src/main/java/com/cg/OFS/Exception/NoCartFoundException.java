package com.cg.OFS.Exception;

public class NoCartFoundException extends Exception {
	public NoCartFoundException(String message) {
		super("No cart found");
	}

}
