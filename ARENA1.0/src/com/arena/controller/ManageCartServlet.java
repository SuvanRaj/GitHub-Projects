package com.arena.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/manageCart")
public class ManageCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		String value = request.getParameter("cart");
		System.out.println("value: " + value);
		if(value != null && value != "")
		{
			switch(value)
			{
				case "Display Cart": {
						//List
				}	break;
				
				case "Add":	{
					
				}	break;
				
				case "Delete":	{
					
				}
			}//Switch block closed
		}//if block closed
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
