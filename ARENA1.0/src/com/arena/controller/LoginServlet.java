package com.arena.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.arena.dao.CustomerDao;
import com.arena.daoImpl.CustomerDaoImpl;
import com.arena.model.Customer;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("uemail");
        String password = request.getParameter("upass");
        
        //CustomerDao cust = new CustomerDaoImpl();
        /*
        Customer cust = new CustomerDaoImpl().getCustomerByName(name);
        if(cust!=null) 
        {
        	if(cust.getCustomerPassword() == pass)
        		out.print("Welcome to ARENA,  " + cust.getCustomerName());
        }
        */
        Customer cust = new CustomerDaoImpl().loginValidate(email,password);
        if(cust!=null) {
        	out.println("Welcome to ARENA,  " + cust.getCustomerName());
        	HttpSession session = request.getSession();
        	session.setAttribute("CustomerName", cust.getCustomerName());
        	session.setAttribute("CustomerRole", cust.getCustomerRole());
        	if(cust.getCustomerRole() == "Admin")
        	{
        		RequestDispatcher rd = request.getRequestDispatcher("AdminPage.jsp");
                rd.forward(request,response);
        	}
        	else
        	{
        		RequestDispatcher rd = request.getRequestDispatcher("HomePage.jsp?msg=Valid User");
                rd.forward(request,response);
        	}
        }
        else {
        	//out.println("Invalid User");
        	RequestDispatcher rd = request.getRequestDispatcher("LoginPage.jsp?msg=Not a valid user");
            rd.include(request,response);
        }
        
	}

}
