package com.cg.dms.controller;

import com.cg.dms.entities.Farmer;
import com.cg.dms.exception.DealerNotFoundException;
import com.cg.dms.exception.FarmerAlreadyExistsException;
import com.cg.dms.exception.FarmerNotFoundException;
import com.cg.dms.service.FarmerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FarmerController {

	private static final Logger LOG = LoggerFactory.getLogger(FarmerController.class);

	@Autowired
	private FarmerService iFarmerService;

	@GetMapping("/farmer")
	public List<Farmer> getAllFarmer() {
		return iFarmerService.getAllFarmer();
	}

	@PostMapping("/farmer")
	public ResponseEntity<Farmer> addfarmer(@RequestBody Farmer farmer) throws FarmerAlreadyExistsException {
		LOG.info("Controller addfarmer");
		Farmer former = iFarmerService.addFarmer(farmer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", " New former is added to the Database");
		LOG.info(headers.toString());
		ResponseEntity<Farmer> response = new ResponseEntity<Farmer>(former, headers, HttpStatus.OK);
		return response;
	}

	@PutMapping("/farmer")
	public ResponseEntity<Farmer> updatefarmer(@RequestBody Farmer farmer) throws FarmerNotFoundException {
		LOG.info("Controller updatefarmer");
		Farmer former = iFarmerService.updateFarmer(farmer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This farmer data is updated in database.");
		ResponseEntity<Farmer> response = new ResponseEntity<Farmer>(former, headers, HttpStatus.OK);
		return response;
	}
	
//	@GetMapping("/getFarmer/{dealerId}")
//	public ResponseEntity<Farmer> getFarmer(@PathVariable(name = "farmerId") int farmerId) throws DealerNotFoundException {
//		LOG.info("getFarmer");
//		Farmer farmer = iFarmerService.getFarmer(farmerId);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "This Farmer is available in the database.");
//		LOG.info(headers.toString());
//		ResponseEntity<Farmer> response = new ResponseEntity<Farmer>(farmer, headers, HttpStatus.OK);
//		return response;
//	}
	
//	@GetMapping("/getFarmer/{dealerId}")
//	public ResponseEntity<Farmer> getFarmer(@PathVariable(name = "farmerId") int dealerId) throws DealerNotFoundException {
//		LOG.info("getFarmer");
//		Farmer farmer = iFarmerService.getFarmer(dealerId);
//		LOG.info(farmer.toString());
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "This Farmer is available in the database.");
//		LOG.info(headers.toString());
//		ResponseEntity<Farmer> response = new ResponseEntity<Farmer>(farmer, headers, HttpStatus.OK);
//		return response;
//	}
}