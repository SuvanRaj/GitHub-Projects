package com.arena.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.arena.dao.CategoryDao;
import com.arena.daoImpl.ConnectionProvider;
import com.arena.model.Category;

public class CategoryDaoImpl implements CategoryDao {
	
	@Override
	public boolean addCategory(Category category) {
		
		try(Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into Category values(?,?,?)");) 
		{	
			//category.setCategoryId();
			pstmt.setString(1,category.getCategoryId());
			pstmt.setString(2,category.getCategoryName());
			pstmt.setString(3,category.getCategoryDesc());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("Category inserted successfuly!");
				return true;
			}	
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		System.err.println("Category failed to insert!");
		return false;
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		try(Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement("update Category set name=?, description=? where id=?");) 
		{
			pstmt.setString(3,category.getCategoryId());
			pstmt.setString(1,category.getCategoryName());
			pstmt.setString(2,category.getCategoryDesc());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("Category updated successfuly!");
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		System.err.println("Category failed to update!");
		return false;
	}

	@Override
	public boolean deleteCategoryByName(String categoryName) {
		// TODO Auto-generated method stub
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from Category where name=?");)
		{	
			pstmt.setString(1,categoryName);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("Category deleted successfuly!");
				return true;
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		System.err.println("Category failed to delete!");
		return false;
	}

	@Override
	public List<Category> getAllCategories() {
		
		List<Category> list = new ArrayList<Category>();
		Category cat;
		
		try(Connection con = ConnectionProvider.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Category");) 
		{
			System.out.println("\n------------------Categories-------------------\n");
			while(rs.next())
			{
				System.out.println("Id: " + rs.getString(1) + "\nName: " + rs.getString(2) + "\nDescription: " + rs.getString(3));
				cat = new Category();
				cat.setCategoryId(rs.getString(1));
				cat.setCategoryName(rs.getString(2));
				cat.setCategoryDesc(rs.getString(3));
				list.add(cat);
			}
			if(list.size() > 0)
				return list;
			else
				return null;
		}
		catch(SQLException e) {
			System.err.println("Categories could not be retrieved!");
			System.out.println(e);
		}
		
		return null;
	}

	@Override
	public Category getCategoryByName(String categoryName) {
		// TODO Auto-generated method stub
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from Category where name=?");) 
		{	
			pstmt.setString(1,categoryName);
			
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("\n-----------------Category Details------------------\n");
			if(rs.next())
			{
				System.out.println("Id: " + rs.getString(1) + "\nName: " + rs.getString(2) + "\nDescription: " + rs.getString(3));
				Category cat = new Category();
				cat.setCategoryId(rs.getString(1));
				cat.setCategoryName(rs.getString(2));
				cat.setCategoryDesc(rs.getString(3));
				return cat;
			}
		}catch(SQLException e) {
			System.err.println("Category data could not be retrieved!");
			System.out.println(e);
		}
		
		return null;
	}

}
