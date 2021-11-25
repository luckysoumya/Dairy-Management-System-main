package com.cg.dms.exception;

public class DealAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -356076669104747933L;

	public DealAlreadyExistsException() {
		super();
	}
	
	public DealAlreadyExistsException(String s) {
		super(s);
	}
	
}
