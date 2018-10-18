package com.arena.daoImpl;

//import java.io.FileInputStream;
//import java.io.FileReader;
//import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.arena.dao.ProductDao;
import com.arena.model.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public boolean addProduct(Product product) {
		
		try(Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into Product values(?,?,?,?,?,?)");) 
		{	
			//product.setProductId();
			pstmt.setString(1,product.getProductId());
			pstmt.setString(2,product.getProductName());
			pstmt.setString(3, product.getProductDesc());
			pstmt.setLong(4, product.getProductPrice());
			pstmt.setInt(5,product.getProductQuantity());
			//pstmt.setBlob(6, product.getProductImage());
			pstmt.setString(6,product.getProductCategory());
			//FileInputStream fin=new FileInputStream("D:\\NIIT\\PROJECT\\Images\\PC\\MortalKombatX.jpg");  
			//pstmt.setBlob(7,fin,fin.available());  
		    //FileReader fr = new FileReader("D:\\NIIT\\PROJECT\\Images\\PC\\Assasin'sCreedBlackFlag.jpg");
		    //pstmt.setCharacterStream(7, fr);
		    //pstmt.setClob(7, product.getProductImage());
		    
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println(product.getProductName() + " registered successfully!");
				return true;
			}	
		}
		catch(SQLException e) {
			System.err.println("Product could not be registered due to an exception!");
			//System.out.println(e);
			e.printStackTrace();
		}
		
		//System.err.println("Product could not be registered!");
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		try(Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement("update Product set name=?, description=?, price=?, quantity=?, category=? where id=?");) 
		{	
			pstmt.setString(6,product.getProductId());
			pstmt.setString(1,product.getProductName());
			pstmt.setString(2, product.getProductDesc());
			pstmt.setDouble(3, product.getProductPrice());
			pstmt.setInt(4,product.getProductQuantity());
			pstmt.setString(5, product.getProductCategory());
			//pstmt.setString(6,product.getProductCategory());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("Product updated successfully!");
				return true;
			}	
		}
		catch(SQLException e) {
			System.err.println("Product could not be updated due to an exception!");
			System.out.println(e);
		}
		
		//System.err.println("Product could not be updated!");
		return false;
	}

	@Override
	public boolean deleteProductByName(String productName) {
		// TODO Auto-generated method stub
		try(Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from Product where name=?");) 
		{	
			pstmt.setString(1,productName);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println(productName + " deleted successfuly!");
				return true;
			}
			else
				System.out.println("Product could not be deleted from DB, result: " + result);
			
		}
		catch(SQLException e) {
			System.out.println("Product could not be deleted due to an exception!");
			System.out.println(e);
		}
		
		//System.out.println("Product could not be deleted from DB");
		return false;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> list = new ArrayList<Product>();
		Product prod;
	
		try (Connection con = ConnectionProvider.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Product");) 
		{		
			System.out.println("\n-----------------Products------------------\n");
			while(rs.next())
			{
				System.out.println("Id: " + rs.getString(1) + "\nName: " + rs.getString(2) + "\nDescription: " + rs.getString(3) + "\nPrice: " + rs.getDouble(4) + 
						"\nQuantity: " + rs.getInt(5) + "\nCategory: " + rs.getString(6));
				prod = new Product();
				prod.setProductId(rs.getString(1));
				prod.setProductName(rs.getString(2));
				prod.setProductDesc(rs.getString(3));
				prod.setProductPrice(rs.getLong(4));
				prod.setProductQuantity(rs.getInt(5));
				prod.setProductCategory(rs.getString(6));
				//prod.setProductImage(rs.getClob(7));
				
				list.add(prod);
			}
			return list;
		}
		catch(SQLException e) {
			System.err.println("Products could not be retrieved!");
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Product getProductByName(String productName) {
		// TODO Auto-generated method stub
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from Product where name=?");) 
		{	
			pstmt.setString(1, productName);
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("\n-----------------Product Details------------------\n");
			if(rs.next())
			{
				System.out.println("Id: " + rs.getString(1) + "\nName: " + rs.getString(2) + "\nDescription: " + rs.getString(3) + "\nPrice: " + rs.getDouble(4) + 
						"\nQuantity: " + rs.getInt(5) + "\nCategory: " + rs.getString(6));
				Product prod = new Product();
				prod.setProductId(rs.getString(1));
				prod.setProductName(rs.getString(2));
				prod.setProductDesc(rs.getString(3));
				prod.setProductPrice(rs.getLong(4));
				prod.setProductQuantity(rs.getInt(5));
				prod.setProductCategory(rs.getString(6));
				//prod.setProductImage(rs.getClob(7));
				return prod;
			}
		}
		catch(SQLException e) {
			System.err.println("Product data could not be retrieved!");
			System.out.println(e);
		}
		return null;
	}
	
	@Override
	public List<Product> getProductsByCategory(String categoryName)
	{
		List<Product> list = new ArrayList<Product>();
		Product prod;
		
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from Product where category=?");)
		{	
			pstmt.setString(1, categoryName);
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("\n-----------------Products------------------\n");
			while(rs.next())
			{
				System.out.println("Id: " + rs.getString(1) + "\nName: " + rs.getString(2) + "\nDescription: " + rs.getString(3) + "\nPrice: " + rs.getDouble(4) + 
						"\nQuantity: " + rs.getInt(5) + "\nCategory: " + rs.getString(6));
				prod = new Product();
				prod.setProductId(rs.getString(1));
				prod.setProductName(rs.getString(2));
				prod.setProductDesc(rs.getString(3));
				prod.setProductPrice(rs.getLong(4));
				prod.setProductQuantity(rs.getInt(5));
				prod.setProductCategory(rs.getString(6));
				//prod.setProductImage(rs.getClob(7));
				
				list.add(prod);
			}
			return list;
		}
		catch(SQLException e)
		{
			System.err.println("Product data by category name could not be retrieved!");
			System.out.println(e);
		}
		
		return null;
	}

}
