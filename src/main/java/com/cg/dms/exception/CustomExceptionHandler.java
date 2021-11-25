package com.cg.dms.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class CustomExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Object> handleCustomerNotFoundException() {

		LOG.error("handleEmployeeNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Customer data not foudnd");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<Object> handleCustomerAlreadyExistsException() {

		LOG.error("handleCustomerAlreadyExistsException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Customer data already exists in database");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<Object> handleCompanyNotFoundException() {

		LOG.error("handleCompanyNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Company data not found");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CompanyAlreadyExistsException.class)
	public ResponseEntity<Object> handleCompanyAlreadyExistsException() {

		LOG.error("handleCompanyAlreadyExistsException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Company already exists");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DealAlreadyExistsException.class)
	public ResponseEntity<Object> handleDealAlreadyExistsException() {
		LOG.error("handleDealAlreadyExistsException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Dealer already exists");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DealerNotFoundException.class)
	public ResponseEntity<Object> handleDealerNotFoundException() {
		LOG.error("handleDealerNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Dealer not found ");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PaymentAlreadyFoundException.class)
	public ResponseEntity<Object> handlePaymentAlreadyFoundException() {
		LOG.error("handlePaymentAlreadyFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "PaymentId already found");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PaymentNotFoundException.class)
	public ResponseEntity<Object> handlePaymentNotFoundException() {
		LOG.error(" handlePaymentNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Payment Not Found");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(FarmerAlreadyExistsException.class)
	public ResponseEntity<Object> FarmerAlreadyExists() {
		LOG.error("FarmerAlreadyExistsException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This Farmer is NOT available in the database.");
		return new ResponseEntity<Object>(null, headers, HttpStatus.NOT_FOUND);
	}

}
