package com.cg.dms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dms.entities.Company;
import com.cg.dms.exception.CompanyNotFoundException;
import com.cg.dms.service.CompanyService;

@RestController
public class CompanyController {

	private static final Logger LOG = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	private CompanyService iCompanyService;

	@PostMapping("/addcompany")
	public ResponseEntity<Company> addcompany(@RequestBody Company company) throws CompanyNotFoundException {
		LOG.info("Controller addCompany");
		Company comp = iCompanyService.insertCompany(company);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", " New company is added to the Database");
		ResponseEntity<Company> response = new ResponseEntity<Company>(comp, headers, HttpStatus.OK);
		return response;
	}

	@DeleteMapping("/deletecompanybyid/{companyid}")
	public ResponseEntity<Company> deletecompanyById(@PathVariable(name = "companyid") int companyid)
			throws CompanyNotFoundException {
		LOG.info("deletecompanybyid");
		Company company = iCompanyService.deleteCompany(companyid);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This company is deleted from the Database");
		ResponseEntity<Company> response = new ResponseEntity<Company>(company, headers, HttpStatus.OK);
		return response;
	}

	@PutMapping("/updatecompany")
	public ResponseEntity<Company> updatecompany(@RequestBody Company company) throws CompanyNotFoundException {
		LOG.info("Controller company");
		Company comp = iCompanyService.updateCompany(company);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This company data is updated in database.");
		ResponseEntity<Company> response = new ResponseEntity<Company>(comp, headers, HttpStatus.OK);
		return response;
	}

	@GetMapping("/getcompanybyid/{companyId}")
	public ResponseEntity<Company> getcompanyById(@PathVariable(name = "companyId") int companyId)
			throws CompanyNotFoundException {
		LOG.info("getcompanyById");
		Company company = iCompanyService.getCompanyById(companyId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This company is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Company> response = new ResponseEntity<Company>(company, headers, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getallcompany")
	public List<Company> getAllCompany() {
		LOG.info("getAllCompany");

		return iCompanyService.getAllCompany();
	}

}
