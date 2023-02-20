package com.masaischool.dto;

import java.util.Set;

public class CategoryImpl implements Category {
	private Integer categoryId;
	private String categoryName;
	private Set<Product> productSet;
	
	public CategoryImpl() {}
	
	public CategoryImpl(Integer categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	@Override
	public Integer getCategoryId() {
		return categoryId;
	}

	@Override
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String getCategoryName() {
		return categoryName;
	}

	@Override
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public Set<Product> getProductSet() {
		return productSet;
	}

	@Override
	public void setProductSet(Set<Product> productSet) {
		this.productSet = productSet;
	}
}