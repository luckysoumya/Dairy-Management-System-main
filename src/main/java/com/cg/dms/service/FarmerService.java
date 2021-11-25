package com.cg.dms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.entities.Farmer;
import com.cg.dms.exception.FarmerAlreadyExistsException;
import com.cg.dms.exception.FarmerNotFoundException;
import com.cg.dms.repository.IFarmerRepository;

@Service
public class FarmerService implements IfarmerService {

	private static final Logger LOG = LoggerFactory.getLogger(FarmerService.class);
	@Autowired
	private IFarmerRepository iFarmerRepository;

	public List<Farmer> getAllFarmer() {
		LOG.info("Get_All_Formers");
		return iFarmerRepository.findAll();
	}

	@Override
	public Farmer addFarmer(Farmer user) throws FarmerAlreadyExistsException {
		LOG.info("Service add Farmer");
		if (!iFarmerRepository.existsById(user.getFarmerId())) {
			LOG.info("New Farmer is Added");
			return iFarmerRepository.save(user);
		} else {
			LOG.info("Farmer Data is already exists");
			throw new FarmerAlreadyExistsException("Farmer already exists");
		}
	}

	@Override
	public Farmer updateFarmer(Farmer user) throws FarmerNotFoundException {
		LOG.info("Service update Farmer");
		if (iFarmerRepository.existsById(user.getFarmerId())) {
			LOG.info(" Farmer Data is Updated");
			return iFarmerRepository.save(user);
		} else {
			LOG.info(user.getFarmerId() + "  Farmer data is Not updated");
			throw new FarmerNotFoundException(" Farmer Data is not updated");
		}
	}

//	public Farmer getFarmer(int dealerId) throws DealerNotFoundException {
//		LOG.info("getFarmerId");
//		Optional<Farmer> farmerOpt = iFarmerRepository.findById(dealerId);
//		if (farmerOpt.isPresent()) {
//			LOG.info("Farmer is available.");
//			return farmerOpt.get();
//		} else {
//			LOG.info("Farmer is NOT available.");
//			throw new DealerNotFoundException(dealerId + " this delaer is not found.");
//		}
//	}

	@Override
	public Farmer validateFarmer(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}