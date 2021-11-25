package com.cg.dms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dealer extends AbstractUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dealerId;

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}
}