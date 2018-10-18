package com.arena.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arena.daoImpl.ProductDaoImpl;
import com.arena.model.Product;

@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50) 

@WebServlet("/manageProducts")
public class ManageProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
       
        String value = request.getParameter("products"); 
    	System.out.println("value: " + value);
    	if(value != null)
    	{
	        switch(value)
	        {		
	        	case "Display Products":{
	        		List<Product> list = new ProductDaoImpl().getAllProducts();
	        		session.setAttribute("ProductList", list);
	        		RequestDispatcher rd = request.getRequestDispatcher("DisplayProducts.jsp");
	                rd.forward(request,response);
	        	}	break;
	        	
	        	case "Add":{
	        		Product prod = new Product();
	        		
	        		prod.setProductId();
	        		
	        		String name = request.getParameter("pname");
	        		prod.setProductName(name);
	        		
	                String description = request.getParameter("pdesc");
	                prod.setProductDesc(description);
	                
	                if(request.getParameter("pprice") != "")
	                {
	                	long price = Long.parseLong(request.getParameter("pprice"));
	                	prod.setProductPrice(price);
	                }
	                
	                if(request.getParameter("pquantity") != "")
	                {
	                	int quantity = Integer.parseInt(request.getParameter("pquantity"));
	                	prod.setProductQuantity(quantity);
	                }
	                
	                String category = request.getParameter("pcategory");
	                prod.setProductCategory(category);
	                
	                //Creating image
	                Part part = request.getPart("pimage");
	                System.out.println("part: " + part);
	                if(part != null)
	                {
		                InputStream fis = part.getInputStream();
		    			byte[] bytes = IOUtils.toByteArray(fis);
		    			String path="D:\\NIIT\\PROJECT\\workspace\\ARENA1.0\\WebContent\\Images\\generated";
		    			String fileName = path + File.separator + prod.getProductName() + ".jpg";
		    			System.out.println(fileName);
		    			FileOutputStream fos = new FileOutputStream(fileName);
		    			fos.write(bytes);
		    			fos.close();
	                }
	
	                if(new ProductDaoImpl().addProduct(prod)) 
	        		{
	        			out.println("Product added successfully");
	        			RequestDispatcher rd = request.getRequestDispatcher("ManageProducts.jsp?msg=Product added successfully");
	                    rd.forward(request,response);
	        		}
	        		else
	        		{
	        			out.println("Product couldn't be added");
	                	RequestDispatcher rd = request.getRequestDispatcher("ManageProducts.jsp?msg=Product could not be added");
	                	rd.forward(request,response);
	        		}
	                
	        	}	break;
	        	
	        	case "Update":{
	        		Product prod = new Product();
	        		
	        		prod.setProductId((String)session.getAttribute("ProductId"));
	        		
	        		String name = request.getParameter("uname");
	        		prod.setProductName(name);
	        		
	                String description = request.getParameter("udesc");
	                prod.setProductDesc(description);
	                
	                if(request.getParameter("uprice") != "")
	                {
	                	long price = Long.parseLong(request.getParameter("uprice"));
	                	prod.setProductPrice(price);
	                }
	                
	                if(request.getParameter("uquantity") != "")
	                {
	                	int quantity = Integer.parseInt(request.getParameter("uquantity"));
	                	prod.setProductQuantity(quantity);
	                }
	                
	                String category = request.getParameter("ucategory");
	                prod.setProductCategory(category);
	                
	        		Part part = request.getPart("uimage");
					System.out.println("part: " + part);
					if(part != null)
					{
					    InputStream fis = part.getInputStream();
						byte[] bytes = IOUtils.toByteArray(fis);
						String path="D:\\NIIT\\PROJECT\\workspace\\ARENA1.0\\WebContent\\Images\\generated";
						String fileName = path + File.separator + prod.getProductName() + ".jpg";
						System.out.println(fileName);
						FileOutputStream fos = new FileOutputStream(fileName);
						fos.write(bytes);
						fos.close();
					}
					if(new ProductDaoImpl().updateProduct(prod)) 
	        		{
	        			out.println("Product updated successfully");
	        			RequestDispatcher rd = request.getRequestDispatcher("ManageProducts.jsp?msg=Product updated successfully");
	                    rd.forward(request,response);
	        		}
	        		else
	        		{
	        			out.println("Product couldn't be updated");
	                	RequestDispatcher rd = request.getRequestDispatcher("ManageProducts.jsp?msg=Product could not be updated");
	                	rd.forward(request,response);
	        		}
	                
	        	}	break;
	    
	        	default: out.println("Wrong option!");
	        }//Switch case closed
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        String productName = request.getParameter("deleteProduct");
        System.out.println("productName to delete: " + productName);
        if(productName != null)
        {
        	if(new ProductDaoImpl().deleteProductByName(productName))
			{
				out.println("Product deleted successfully");
				RequestDispatcher rd = request.getRequestDispatcher("ManageProducts.jsp?msg=Product deleted successfully");
                rd.forward(request,response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("ManageProducts.jsp?msg=Product deleted successfully");
				rd.forward(request,response);
				out.println("Product couldn't be deleted");
			}
        }
        
        productName = request.getParameter("updateProduct");
        System.out.println("productName to update: " + productName);
        if(productName != null)
        {
        	Product prod = new ProductDaoImpl().getProductByName(productName);
        	session.setAttribute("UpdateProduct", prod);
        	RequestDispatcher rd = request.getRequestDispatcher("UpdateProduct.jsp");
			rd.forward(request,response);
        }
        
	}

}
