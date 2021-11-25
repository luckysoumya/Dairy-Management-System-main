package com.cg.dms.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.entities.CompanyPayment;
import com.cg.dms.entities.CustomerPayment;
import com.cg.dms.entities.DealerPayment;
import com.cg.dms.entities.Payment;
import com.cg.dms.exception.PaymentAlreadyFoundException;
import com.cg.dms.repository.ICompanyPaymentRepository;
import com.cg.dms.repository.ICustomerPaymentRepository;
import com.cg.dms.repository.IDealerPaymentRepository;
import com.cg.dms.repository.IPaymentRepository;

@Service
public class PaymentService {
	private static final Logger LOG = LoggerFactory.getLogger(PaymentService.class);
	@Autowired
	private IPaymentRepository ipaymentrepository;
	@Autowired
	private IDealerPaymentRepository idealerpaymentrepo;
	@Autowired
	private ICompanyPaymentRepository icompanypaymentrepository;
	@Autowired
	private ICustomerPaymentRepository icustomerpaymentrepository;


//	public Payment insertDealerToComapnyPayment(Payment payment)throws PaymentNotFoundException;
	public Payment insertDealerToComapnyPayment(DealerPayment payment) throws PaymentAlreadyFoundException {
		LOG.info("Insert Dealer to Company Payment");
		Optional<DealerPayment> dealer = idealerpaymentrepo.findById(payment.getPaymentId());
		if (dealer.isPresent()) {
			throw new PaymentAlreadyFoundException(payment.getPaymentId() + " PaymentId already found");
		} else {
			LOG.info("Insert dealer into company payment");
			return ipaymentrepository.save(payment);
		}

	}

	public Payment insertCompanyToFarmerPayment(CompanyPayment payment) throws PaymentAlreadyFoundException {

		LOG.info("Insert Comapany To Farmer ");
		Optional<CompanyPayment> company = icompanypaymentrepository.findById(payment.getPaymentId());
		if (company.isPresent()) {
			throw new PaymentAlreadyFoundException(payment.getPaymentId() + "PaymentId already found ");
		} else {
			LOG.info("Insert company into farmer payment");
			return icompanypaymentrepository.save(payment);
		}

	}
	
	public Payment insertCustomerToDelearPayment(CustomerPayment payment) throws PaymentAlreadyFoundException{
		LOG.info("Insert Customer to Dealer ");
		Optional<CustomerPayment>  customer = icustomerpaymentrepository.findById(payment.getPaymentId());
		if(customer.isPresent()) {
			throw new PaymentAlreadyFoundException(payment.getPaymentId()+"PaymentId already found");
		}else {
			LOG.info("Insert Customer into Dealer ");
			return icustomerpaymentrepository.save(payment);
		}
	}
	
//	public List<Payment> viewAllpaymentsCustomer(int customerId) throws PaymentNotFoundException{
//		LOG.info("View_All_Payment_OF_Id");
//		List<Payment> pay = icustomerpaymentrepository.fin(customerId);
//	//	boolean payment = icustomerpaymentrepository.existsById(null);
////		if(payment) {
////			LOG.info("Customer payments  found");
////			return  (List<Payment>) pay.get();
////		}else {
////			LOG.info("Customer payments NOT_FOUND");
////			throw new PaymentNotFoundException(customerId+" --> Id payments not found");
////
//		
//		return List<Payment> ;
//	}
	

	
	
	
	
//	public Payment insertCompanyToFarmerPayment(Payment payment)throws PaymentNotFoundException;   --- done
//	public Payment insertDealerToComapnyPayment(Payment payment)throws PaymentNotFoundException;   --- done
//	public Payment insertCustomerToDelearPayment(Payment payment)throws PaymentNotFoundException;  --- done
//	
//	
//	public List<Payment> viewAllpaymentsCustomer(int customerId) throws CustomerNotFoundException;
//	public List<Payment> viewAllpaymentsDealer(int delearId) throws CustomerNotFoundException;
//	public List<Payment> viewAllpaymentsCompany(int companyId) throws CustomerNotFoundException;
//	
//	public Payment calculateBillForCustomer(int customerId)throws CustomerNotFoundException;
//	public Payment calculateBillForDealer(int dealerId)throws CustomerNotFoundException;
//	public Payment calculateBillForCompany(int companyId)throws CustomerNotFoundException;
}
