package com.arena.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.arena.dao.CartDao;
import com.arena.model.Cart;
import com.arena.model.Customer;
import com.arena.model.Product;

public class CartDaoImpl implements CartDao {

	@Override
	public boolean addToCart(Cart cart) {
		try(Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into Cart values(?,?,?,?,?)");) 
		{	
			
		}
		catch(SQLException e)
		{
			System.err.println("Product failed to insert to cart");
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean deleteItemFromCart(Customer cust, Product prod) {
		
		return false;
	}

	@Override
	public boolean updateItemInCart(Customer cust, Product prod) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cart> getAllItems(String customerId) {
		// TODO Auto-generated method stub
		List<Cart> list = new ArrayList<Cart>();
		
		
		try(Connection con = ConnectionProvider.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select cust.name, prod.name, c.productPrice, c.productQuantity, c.productTotal " + 
															"from CART c join CUSTOMER cust on c.CustomerId = ? join PRODUCT prod on c.productId = prod.Id");)
			//ResultSet rs = stmt.executeQuery("select cust.name, prod.name, c.productPrice, c.productQuantity, c.productTotal " + 
			//									"from CART c join CUSTOMER cust on c.CustomerId = ? join PRODUCT prod on c.productId = prod.Id");) 
		{	
			pstmt.setString(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("\n--------------Items---------------\n");
			while(rs.next())
			{
				System.out.println("Customer Name: " + rs.getString(1) + "\nProductName: " + rs.getString(2) + "\nPrice: " + rs.getLong(3) + 
									"\nQuantity: " + rs.getInt(4) + "\nProductTotal: " + rs.getLong(5));
				
			}
			return list;
		}
		catch(SQLException e)
		{
			System.err.println("Product failed to insert to cart");
			System.out.println(e);
		}
		return null;
	}

}
