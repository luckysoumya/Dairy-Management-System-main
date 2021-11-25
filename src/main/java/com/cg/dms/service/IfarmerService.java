package com.cg.dms.service;

import java.util.List;

import com.cg.dms.entities.Farmer;
import com.cg.dms.exception.DealerNotFoundException;
import com.cg.dms.exception.FarmerAlreadyExistsException;
import com.cg.dms.exception.FarmerNotFoundException;

public interface IfarmerService {
	
	public Farmer validateFarmer(String username, String password) throws Exception;

	public Farmer addFarmer(Farmer user) throws FarmerAlreadyExistsException;

	public Farmer updateFarmer(Farmer user) throws FarmerNotFoundException;

	public List<Farmer> getAllFarmer();

//	public Farmer getFarmer(int dealerId)  ;


}
