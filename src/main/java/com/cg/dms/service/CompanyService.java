package com.cg.dms.service;

import com.cg.dms.entities.Company;
import com.cg.dms.entities.Dealer;
import com.cg.dms.entities.Farmer;
import com.cg.dms.exception.CompanyNotFoundException;
import com.cg.dms.exception.CustomerAlreadyExistsException;
import com.cg.dms.repository.ICompanyRepository;
import com.cg.dms.repository.IDelearRepository;
import com.cg.dms.repository.IFarmerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {

	private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private ICompanyRepository iCompanyRepository;
	@Autowired
	private IFarmerRepository iFarmerRepository;
	@Autowired
	private IDelearRepository iDealerRepository;

	// public Company insertCompany(Company company);
	public Company insertCompany(Company company) throws CustomerAlreadyExistsException {
		LOG.info("Service addCompany");
		if (iCompanyRepository.existsById(company.getId())) {
			LOG.info("Company Data is already exists");
			throw new CustomerAlreadyExistsException(company.getId() + "Company already exists");
		} else {
			LOG.info("New Company is Added");
			return iCompanyRepository.save(company);
		}
	}

	// public Company deleteCompany(Company company) ;
	public Company deleteCompany(int companyId) throws CompanyNotFoundException {
		LOG.info("Service deleteCompanyById");
		Optional<Company> company = iCompanyRepository.findById(companyId);
		if (company.isPresent()) {
			LOG.info("Company is Available");
			iCompanyRepository.deleteById(companyId);
			return company.get();
		} else {
			LOG.info("Company is not available");
			throw new CompanyNotFoundException(companyId + " -> Company is not found.");
		}
	}

	// public Company updateCompany(Company company) throws
	// CompanyNotFoundException;
	public Company updateCompany(Company company) throws CompanyNotFoundException {
		LOG.info("Service companyDealer");
		if (iCompanyRepository.existsById(company.getId())) {
			LOG.info("Company Data is Updated");
			return iCompanyRepository.save(company);
		} else {
			LOG.info(company.getCompanyName() + " Company data is Not updated");
			throw new CompanyNotFoundException("Company Data is not updated");
		}
	}

	public Company getCompanyById(int companyId) throws CompanyNotFoundException {
		LOG.info("getCompanyId");
		Optional<Company> companyOpt = iCompanyRepository.findById(companyId);
		if (companyOpt.isPresent()) {
			LOG.info("company is available.");
			return companyOpt.get();
		} else {
			LOG.info("company is NOT available.");
			throw new CompanyNotFoundException(companyId + " this company is not found.");
		}
	}

	public List<Company> getAllCompany() {
		LOG.info("Service getAllCompany");
		return iCompanyRepository.findAll();
	}

	public List<Farmer> getAllFormers() {
		LOG.info("get all Farmers");
		return iFarmerRepository.findAll();
	}

	public List<Dealer> getAllDealers() {
		LOG.info("get all Dealers");
		return iDealerRepository.findAll();
	}

	
	

}







// ---< Scrap >

//public Company deleteCompany(Company company) ;
//	public Company deleteCompanyById(Company company) throws CompanyNotFoundException {
//		LOG.info("Service deleteCompanyById");
//
//		if (iCompanyRepository.existsById(company.getId())) {
//			LOG.info("Company is Available");
//			iCompanyRepository.deleteById(company.getId());
//			return company;
//		} else {
//			LOG.info("Company is not available");
//			throw new CompanyNotFoundException(company.getId() + " -> Company is not found.");
//		}
//	}