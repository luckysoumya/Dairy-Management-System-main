package com.cg.dms.service;

import org.springframework.stereotype.Service;

import com.cg.dms.repository.ICustomerPaymentRepository;

@Service
public class CustomerPaymentService implements ICustomerPaymentService {
	
	private ICustomerPaymentRepository icustomerpaymentrepository;

}
