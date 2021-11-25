package com.cg.dms.exception;

public class CustomerAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6048204975685882709L;

	public CustomerAlreadyExistsException() {
		super();
	}
	
	public CustomerAlreadyExistsException(String s) {
		super(s);
	}
	
}
