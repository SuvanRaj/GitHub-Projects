package com.arena.dao;

import java.util.List;
import com.arena.model.Product;

public interface ProductDao {
	
	boolean addProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProductByName(String productName);
	List<Product> getAllProducts();
	Product getProductByName(String productName);
	List<Product> getProductsByCategory(String categoryName);

}
