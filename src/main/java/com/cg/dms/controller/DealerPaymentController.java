package com.cg.dms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dms.service.DealerPaymentService;

@RestController
public class DealerPaymentController {

	@Autowired
	private DealerPaymentService idealerpaymentservice;
}
