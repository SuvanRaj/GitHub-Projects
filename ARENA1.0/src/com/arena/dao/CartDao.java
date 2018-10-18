package com.arena.dao;

import java.util.List;

import com.arena.model.Cart;
import com.arena.model.Customer;
import com.arena.model.Product;

public interface CartDao {
	
	boolean addToCart(Cart cart);
	boolean deleteItemFromCart(Customer cust, Product prod);
	boolean updateItemInCart(Customer cust, Product prod);
	List<Cart> getAllItems(String customerId);
	
}
