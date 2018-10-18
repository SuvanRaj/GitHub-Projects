package com.arena.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arena.daoImpl.CategoryDaoImpl;
import com.arena.model.Category;

@WebServlet("/manageCategories")
public class ManageCategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        String value = request.getParameter("categories");
        System.out.println("value: " + value);
        if(value != null)
        {
        	switch(value)
        	{
	        	case "Display Categories":{
	        		List<Category> list = new CategoryDaoImpl().getAllCategories();
	                session.setAttribute("CategoryList", list);
	                RequestDispatcher rd = request.getRequestDispatcher("DisplayCategories.jsp");
	                rd.forward(request,response);
	        	}	break;
	        	case "Add": {
	        		Category cat = new Category();
	        		
	        		cat.setCategoryId();
	            	
	            	String name = request.getParameter("cname");
	            	cat.setCategoryName(name);
	            	
	            	String desc = request.getParameter("cdesc");
	            	cat.setCategoryDesc(desc);
	            	
	            	if(new CategoryDaoImpl().addCategory(cat))
	            	{
	            		out.println("Category added successfully");
	        			RequestDispatcher rd = request.getRequestDispatcher("ManageCategories.jsp?msg=Category added successfully");
	                    rd.forward(request,response);
	            	}
	            	else
	            	{
	            		out.println("Category couldn't be added");
	                	RequestDispatcher rd = request.getRequestDispatcher("ManageCategories.jsp?msg=Category could not be added");
	                	rd.forward(request,response);
	            	}
	        	}	break;
	        	case "Update": {
	        		Category cat = new Category();
	        		
	        		cat.setCategoryId((String)session.getAttribute("UpdateCategoryId"));
	            	
	            	String name = request.getParameter("uname");
	            	cat.setCategoryName(name);
	            	
	            	String desc = request.getParameter("udesc");
	            	cat.setCategoryDesc(desc);
	            	
	            	if(new CategoryDaoImpl().updateCategory(cat))
	            	{
	        			RequestDispatcher rd = request.getRequestDispatcher("ManageCategories.jsp?msg=Category updated successfully");
	                    rd.forward(request,response);
	            	}
	            	else
	            	{
	            		RequestDispatcher rd = request.getRequestDispatcher("ManageCategories.jsp?msg=Category could not be updated");
	                    rd.forward(request,response);
	            	}
	            	
	        	}
	        	default: out.println("Wrong option selected!");
        	}//Switch case closed
        }
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
        
		String categoryName = request.getParameter("deleteCategory");
        System.out.println("categoryName to delete: " + categoryName);
        if(categoryName != null)
        {
        	if(new CategoryDaoImpl().deleteCategoryByName(categoryName))
			{
        		List<Category> list = new CategoryDaoImpl().getAllCategories();
                session.setAttribute("CategoryList", list);
        		RequestDispatcher rd = request.getRequestDispatcher("ManageCategories.jsp?msg=Category deleted successfully");
                rd.forward(request,response);
			}
        	else
        	{
        		RequestDispatcher rd = request.getRequestDispatcher("ManageCategories.jsp?msg=Category could not be deleted");
                rd.forward(request,response);
        	}
        }
        
        categoryName = request.getParameter("updateCategory");
        System.out.println("categoryName to update: " + categoryName);
        if(categoryName != null)
        {
        	Category cat = new CategoryDaoImpl().getCategoryByName(categoryName);
        	session.setAttribute("UpdateCategory", cat);
        	RequestDispatcher rd = request.getRequestDispatcher("UpdateCategory.jsp");
			rd.forward(request,response);
        }
		//doPost(request, response);
	}

}
