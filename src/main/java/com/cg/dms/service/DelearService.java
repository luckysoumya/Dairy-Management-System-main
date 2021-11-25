package com.cg.dms.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.entities.Dealer;
import com.cg.dms.exception.DealAlreadyExistsException;
import com.cg.dms.exception.DealerNotFoundException;
import com.cg.dms.repository.ICompanyRepository;
import com.cg.dms.repository.IDelearRepository;

@Service
public class DelearService implements IDelearService {

	private static final Logger LOG = LoggerFactory.getLogger(DelearService.class);

	@Autowired
	private IDelearRepository iDealerRepository;
	@Autowired
	private ICompanyRepository iCompanyRepository;

	// public Dealer insertDealer(Dealer dealer);
	public Dealer insertDealer(Dealer dealer) throws DealAlreadyExistsException {

		LOG.info("Service addDealer");
		if (!iDealerRepository.existsById(dealer.getDealerId())) {
			LOG.info("New Dealer is Added");
			return iDealerRepository.save(dealer);
		} else {
			LOG.info("Dealer Data is already exists");
			throw new DealAlreadyExistsException("Dealer already exists");
		}
	}


	//public List<Dealer> getDealer(int dealerId);
	public Dealer getDealer(int dealerId) throws DealerNotFoundException {
		LOG.info("getDealerId");
		Optional<Dealer> dealerOpt = iDealerRepository.findById(dealerId);
		if (dealerOpt.isPresent()) {
			LOG.info("dealer is available.");
			return dealerOpt.get();
		} else {
			LOG.info("dealer is NOT available.");
			throw new DealerNotFoundException(dealerId + " this delaer is not found.");
		}
	}

	// public Dealer updateDealer(Dealer dealer) throws DealerNotFoundException;
	public Dealer updateDealer(Dealer dealer) throws DealerNotFoundException {
		LOG.info("Service updateDealer");
		if (iDealerRepository.existsById(dealer.getDealerId())) {
			LOG.info("Employee Data is Updated");
			return iDealerRepository.save(dealer);
		} else {
			LOG.info(dealer.getDealerId() + " dealer data is Not updated");
			throw new DealerNotFoundException("delaer Data is not updated");
		}
	}

	//public Dealer deleteDealer(Dealer dealer) throws DealerNotFoundException;
	public Dealer deleteDealer(int dealerId) throws DealerNotFoundException {
		LOG.info("Service deleteDealerById");
		Optional<Dealer> dealOpt = iDealerRepository.findById(dealerId);
		if (dealOpt.isPresent()) {
			LOG.info("Dealer is Available");
			iDealerRepository.deleteById(dealerId);
			return dealOpt.get();
		} else {
			LOG.info("Dealer is not available");
			throw new DealerNotFoundException(dealerId + " this dealer is not found.");
		}
	}



}



