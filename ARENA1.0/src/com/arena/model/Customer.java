package com.arena.model;

import java.sql.Date;
import java.util.*;

public class Customer implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String customerId;
	private String customerName;
	private String customerPassword;
	private String customerGender;
	private String customerEmail;
	private Date customerDOB;
	private long customerContact;
	private String customerAddr;
	private String customerRole;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId() {
		this.customerId = UUID.randomUUID().toString().substring(0,10);
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	
	public Date getCustomerDOB() {
		return customerDOB;
	}
	public void setCustomerDOB(Date customerDOB) {
		this.customerDOB = customerDOB;
	}
	
	
	public long getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(long customerContact) {
		this.customerContact = customerContact;
	}
	
	
	public String getCustomerAddr() {
		return customerAddr;
	}
	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}

	public String getCustomerRole() {
		return customerRole;
	}
	public void setCustomerRole(String customerRole) {
		this.customerRole = customerRole;
	}
}
