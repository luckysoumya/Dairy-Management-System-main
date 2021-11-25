package com.cg.dms.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class CompanyPayment extends Payment{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6450820627942528950L;
	@ManyToOne
	@JoinColumn(name ="farmerId")
	private Farmer farmer;

	@ManyToOne
	@JoinColumn(name="id")
	private Company company;
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

}
