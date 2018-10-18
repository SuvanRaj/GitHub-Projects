package com.arena.model;

import java.sql.Clob;
import java.util.UUID;

public class Product implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String productId;
	private String productName;
	private String productDesc;
	private long productPrice;
	private int productQuantity;
	private String productCategory;
	private Clob productImage;
	
	
	public String getProductId() {
		return productId;
	}
	public void setProductId() {
		this.productId = UUID.randomUUID().toString().substring(0,10);
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
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
	
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	public Clob getProductImage() {
		return productImage;
	}
	public void setProductImage(Clob productImage) {
		this.productImage = productImage;
	}
	
}
