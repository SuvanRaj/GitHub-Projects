package com.arena.dao;

import java.util.List;
import com.arena.model.Category;

public interface CategoryDao {
	
	boolean addCategory(Category category);
	boolean updateCategory(Category category);
	boolean deleteCategoryByName(String categoryName);
	List<Category> getAllCategories();
	Category getCategoryByName(String categoryName);

}
