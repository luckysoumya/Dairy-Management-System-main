package com.cg.dms.service;

import com.cg.dms.entities.Dealer;
import com.cg.dms.exception.DealerNotFoundException;

public interface IDelearService {

	public Dealer insertDealer(Dealer dealer);

	public Dealer updateDealer(Dealer dealer) throws DealerNotFoundException;

	public Dealer deleteDealer(int dealer) throws DealerNotFoundException;

	public Dealer getDealer(int dealerId) throws DealerNotFoundException;

//	public List<Customer> getAllCustomers();

//	public List<Customer> getCustomer(int customerId);

}
