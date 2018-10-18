package com.arena.model;

import java.util.UUID;

public class Category implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String categoryId;
	private String categoryName;
	private String categoryDesc;
	
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId() {
		this.categoryId = UUID.randomUUID().toString().substring(0,10);
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

}
