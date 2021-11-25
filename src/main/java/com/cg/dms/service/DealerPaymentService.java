package com.cg.dms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.repository.IDealerPaymentRepository;

@Service
public class DealerPaymentService implements IDealerPaymentService {
	
	@Autowired
	private IDealerPaymentRepository idealerpaymentrepo;

}
