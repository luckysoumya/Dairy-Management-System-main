package com.cg.dms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.repository.ICompanyPaymentRepository;

@Service
public class CompanyPaymentService implements ICompanyPaymentService {

	@Autowired
	private ICompanyPaymentRepository icompanypaymentrepository;
}
