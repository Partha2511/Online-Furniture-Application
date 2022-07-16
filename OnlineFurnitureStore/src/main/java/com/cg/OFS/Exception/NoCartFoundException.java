package com.cg.OFS.Exception;

@SuppressWarnings("serial")
public class NoCartFoundException extends Exception {
	public NoCartFoundException(String message) {
		super("No cart found");
	}

}
