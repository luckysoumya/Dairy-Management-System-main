package com.cg.dms.service;

import java.util.List;

import com.cg.dms.entities.Customer;
import com.cg.dms.exception.CustomerNotFoundException;

public interface ICustomerService {

	public Customer insertCustomer(Customer customer);
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
	public Customer deleteCustomer(int customer) throws CustomerNotFoundException;
	public List<Customer>viewCustomers() throws CustomerNotFoundException;
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException;
//	public Customer validateCustomer(String username, String password) throws CustomerNotFoundException;
}
