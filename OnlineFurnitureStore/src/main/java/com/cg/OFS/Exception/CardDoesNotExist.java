package com.cg.OFS.Exception;

@SuppressWarnings("serial")
public class CardDoesNotExist extends RuntimeException{

	public CardDoesNotExist(String msg) {
		super(msg);
	}

}
