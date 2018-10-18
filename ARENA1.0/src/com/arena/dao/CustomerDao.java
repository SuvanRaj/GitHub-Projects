package com.arena.dao;

import java.util.List;
import com.arena.model.Customer;

public interface CustomerDao {
	
	boolean addCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean deleteCustomer(Customer customer);
	List<Customer> getAllCustomers();
	//Customer getCustomerById(String customerId);
	Customer getCustomerByName(String customerName);

}
