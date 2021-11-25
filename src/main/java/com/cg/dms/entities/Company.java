package com.cg.dms.entities;

import javax.persistence.*;

@Entity 
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String companyName;

	private String email;

	private String password;

	private String mobileNumber;

	private String address;

	public Company() {
	}

	public Company(String companyName, String email, String password, String mobileNumber, String address) {
		this.companyName = companyName;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}