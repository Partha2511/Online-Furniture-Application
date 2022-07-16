package com.cg.OFS.Exception;

@SuppressWarnings("serial")
public class BillNumberDoesNotExist extends RuntimeException{
	
	public BillNumberDoesNotExist(String msg) {
		super(msg);
	}
}
