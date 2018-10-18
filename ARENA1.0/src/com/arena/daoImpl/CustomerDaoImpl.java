package com.arena.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.arena.dao.CustomerDao;
import com.arena.daoImpl.ConnectionProvider;
import com.arena.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	@Override
	public boolean addCustomer(Customer customer) {
		
		try(Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into Customer values(?,?,?,?,?,?,?,?,?)");) 
		{	
			//customer.setCustomerId();
			pstmt.setString(1,customer.getCustomerId());
			pstmt.setString(2,customer.getCustomerName());
			pstmt.setString(3, customer.getCustomerPassword());
			pstmt.setString(4, customer.getCustomerGender());
			pstmt.setString(5,customer.getCustomerEmail());
			pstmt.setDate(6, customer.getCustomerDOB());
			pstmt.setLong(7,customer.getCustomerContact());
			pstmt.setString(8,customer.getCustomerAddr());
			pstmt.setString(9, customer.getCustomerRole());
			
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println(customer.getCustomerName() + ", You registered successfuly!");
				return true;
			}	
		}
		catch(SQLException e) {
			System.err.println("Customer could not be registered due to an exception!");
			System.out.println(e);
		}
		
		System.err.println("Customer could not be registered!");
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
	
		try(Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement("update Customer set name=?, password=?, gender=?, email=?, dob=?, contact=?, addr=? where email=?");) 
		{	
			pstmt.setString(8,customer.getCustomerEmail());
			pstmt.setString(1,customer.getCustomerName());
			pstmt.setString(2, customer.getCustomerPassword());
			pstmt.setString(3,customer.getCustomerGender());
			pstmt.setString(4, customer.getCustomerEmail());
			pstmt.setDate(5, customer.getCustomerDOB());
			pstmt.setLong(6,customer.getCustomerContact());
			pstmt.setString(7,customer.getCustomerAddr());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println(customer.getCustomerName() + ", Your details updated successfuly!");
				return true;
			}	
			
		}
		catch(SQLException e) {
			System.err.println("Customer details could not be updated due to an exception!");
			System.out.println(e);
		}
		
		System.err.println("Customer details could not be updated!");
		return false;
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		
		try(Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from Customer where name=?");) 
		{	
			
			pstmt.setString(1,customer.getCustomerName());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println(customer.getCustomerName() + ", Your data deleted successfuly!");
				return true;
			}	
			
		}
		catch(SQLException e) {
			System.err.println("Customer could not be deleted due to an exception!");
			System.out.println(e);
		}
		
		System.err.println("Customer could not be deleted!");
		return false;
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> list = new ArrayList<Customer>();
		Customer cust;
	
		try (Connection con = ConnectionProvider.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Customer");) 
		{	
			
			System.out.println("\n-----------------Customers------------------\n");
			while(rs.next())
			{
				System.out.println("Id: " + rs.getString(1) + "\nName: " + rs.getString(2) + "\nGender: " + rs.getString(4) + 
						"\nEmail: " + rs.getString(5) + "\nDateOfBirth: " + rs.getDate(6) + 
						"\nContactNumber: " + rs.getLong(7) + "\nAddress: " + rs.getString(8) + "\nRole: " + rs.getString(9));
				cust = new Customer();
				cust.setCustomerId(rs.getString(1));
				cust.setCustomerName(rs.getString(2));
				cust.setCustomerPassword(rs.getString(3));
				cust.setCustomerGender(rs.getString(4));
				cust.setCustomerEmail(rs.getString(5));
				cust.setCustomerDOB(rs.getDate(6));
				cust.setCustomerContact(rs.getLong(7));
				cust.setCustomerAddr(rs.getString(8));
				cust.setCustomerRole(rs.getString(9));
				list.add(cust);
			}
			return list;
		}
		catch(SQLException e) {
			System.err.println("Customer data could not be retrieved!");
			System.out.println(e);
		}
		return null;
	}

	/*
	@Override
	public Customer getCustomerById(String customerId) {
		
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from Customer where id=?");) 
		{	
			pstmt.setString(1,customerId);
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("-----------------Customer Details------------------\n\n\n");
			if(rs.next())
			{
				System.out.println("Id: " + rs.getString(1) + "\nName: " + rs.getString(2) + "\nEmail: " + rs.getString(4) + 
						"\nDateOfBirth: " + rs.getDate(5) + "\nContactNumber: " + rs.getLong(6) + "\nAddress: " + rs.getString(7));
				Customer cust = new Customer();
				cust.setCustomerId(rs.getString(1));
				cust.setCustomerName(rs.getString(2));
				cust.setCustomerPassword(rs.getString(3));
				cust.setCustomerEmail(rs.getString(4));
				cust.setCustomerDOB(rs.getDate(5));
				cust.setCustomerContact(rs.getLong(6));
				cust.setCustomerAddr(rs.getString(7));
				return cust;
			}
		}
		catch(SQLException e) {
			System.err.println("Customer data could not be retrieved!");
			System.out.println(e);
		}
		return null;
	}
	*/

	@Override
	public Customer getCustomerByName(String customerName) {
		
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from Customer where name=?");) 
		{	
			pstmt.setString(1,customerName);
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("\n-----------------Customer Details------------------\n");
			if(rs.next())
			{
				System.out.println("Id: " + rs.getString(1) + "\nName: " + rs.getString(2) + "\nGender: " + rs.getString(4) + 
						"\nEmail: " + rs.getString(5) + "\nDateOfBirth: " + rs.getDate(6) + 
						"\nContactNumber: " + rs.getLong(7) + "\nAddress: " + rs.getString(8) + "\nRole: " + rs.getString(9));
				Customer cust = new Customer();
				cust.setCustomerId(rs.getString(1));
				cust.setCustomerName(rs.getString(2));
				cust.setCustomerPassword(rs.getString(3));
				cust.setCustomerGender(rs.getString(4));
				cust.setCustomerEmail(rs.getString(5));
				cust.setCustomerDOB(rs.getDate(6));
				cust.setCustomerContact(rs.getLong(7));
				cust.setCustomerAddr(rs.getString(8));
				cust.setCustomerRole(rs.getString(9));
				return cust;
			}
		}
		catch(SQLException e) {
			System.err.println("Customer data could not be retrieved!");
			System.out.println(e);
		}
		
		return null;
	}
	
	public Customer loginValidate(String email, String password)
	{
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from Customer where email=? and password=?");) 
		{	
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				System.out.println("\nValid User\n");
				System.out.println("Id: " + rs.getString(1) + "\nName: " + rs.getString(2) + "\nGender: " + rs.getString(4) + 
									"\nEmail: " + rs.getString(5) + "\nDateOfBirth: " + rs.getDate(6) + 
									"\nContactNumber: " + rs.getLong(7) + "\nAddress: " + rs.getString(8) + "\nRole: " + rs.getString(9));
				Customer cust = new Customer();
				cust.setCustomerId(rs.getString(1));
				cust.setCustomerName(rs.getString(2));
				cust.setCustomerPassword(rs.getString(3));
				cust.setCustomerGender(rs.getString(4));
				cust.setCustomerEmail(rs.getString(5));
				cust.setCustomerDOB(rs.getDate(6));
				cust.setCustomerContact(rs.getLong(7));
				cust.setCustomerAddr(rs.getString(8));
				cust.setCustomerRole(rs.getString(9));
				return cust;
			}
			else
			{
				System.out.println("\nInvalid User\n");
			}
		}
		catch(SQLException e) {
			System.err.println("Customer data could not be retrieved!");
			System.out.println(e);
		}
		return null;
	}

}
