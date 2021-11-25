package com.cg.dms.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class Payment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8033530529788101286L;
	
	@Id
	private int paymentId;
	private LocalDateTime dateTime;
	private float bill;
	private int milkunits;
	private double unitprice;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public float getBill() {
		return bill;
	}

	public void setBill(float bill) {
		this.bill = bill;
	}

	public int getMilkunits() {
		return milkunits;
	}

	public void setMilkunits(int milkunits) {
		this.milkunits = milkunits;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

}
