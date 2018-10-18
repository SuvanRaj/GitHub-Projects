package com.arena.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arena.daoImpl.CustomerDaoImpl;
import com.arena.model.Customer;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("rname");
        String password = request.getParameter("rpass");
        String email = request.getParameter("remail");
        String gender = request.getParameter("rgender");
        //Date dob = Date.valueOf(request.getParameter("rdob"));
        //long contact = Long.parseLong(request.getParameter("rcontact"));
        String address = request.getParameter("raddr");
        
        Customer cust = new Customer();
        cust.setCustomerId();
        cust.setCustomerName(name);
        cust.setCustomerPassword(password);
        cust.setCustomerEmail(email);
        cust.setCustomerGender(gender);
        if(request.getParameter("rdob") != "")
        {
        	Date dob = Date.valueOf(request.getParameter("rcontact"));
        	cust.setCustomerDOB(dob);
        }
        if(request.getParameter("rcontact") != "")
        {
        	long contact = Long.parseLong(request.getParameter("rcontact"));
        	cust.setCustomerContact(contact);
        }
        cust.setCustomerAddr(address);
        cust.setCustomerRole("User");
        
        if(new CustomerDaoImpl().addCustomer(cust)) 
        {
        	RequestDispatcher rd = request.getRequestDispatcher("LoginPage.jsp?msg=Successfully registered! Login to proceed.");
            rd.forward(request,response);  
        }
        else
        {
        	RequestDispatcher rd = request.getRequestDispatcher("SignupPage.jsp?msg=Registration Error");
            rd.include(request,response);
        }
	}

}
