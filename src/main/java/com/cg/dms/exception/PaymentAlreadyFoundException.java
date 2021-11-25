package com.cg.dms.exception;

public class PaymentAlreadyFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3255129259567801528L;

	public PaymentAlreadyFoundException() {
		super();
	}
	
	public PaymentAlreadyFoundException(String s) {
		super(s);
	}
}
