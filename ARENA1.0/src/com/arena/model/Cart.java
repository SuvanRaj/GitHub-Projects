package com.arena.model;

public class Cart implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cartId;
	private Product prod;
	private Customer cust;
	private long productPrice;
	private int productQuantity;
	private long productTotal;
	
	
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	
	
	public Product getProd() {
		return prod;
	}
	public void setProd(Product prod) {
		this.prod = prod;
	}
	
	
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	
	
	public long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	
	
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	
	public long getProductTotal() {
		return productTotal;
	}
	public void setProductTotal(long productTotal) {
		this.productTotal = productTotal;
	}

}
