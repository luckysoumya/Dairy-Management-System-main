package com.cg.dms.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="delearpayment_table")
public class DealerPayment extends Payment {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5903323702835773942L;
	

	@ManyToOne
	@JoinColumn(name = "id")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name="dealerId")
	private Dealer dealer;

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
		
	
}
