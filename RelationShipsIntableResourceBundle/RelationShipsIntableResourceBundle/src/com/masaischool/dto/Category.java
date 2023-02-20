package com.masaischool.dto;

import java.util.Set;

public interface Category {
	public Integer getCategoryId();
	public void setCategoryId(Integer categoryId);
	public String getCategoryName();
	public void setCategoryName(String categoryName);
	public Set<Product> getProductSet();
	public void setProductSet(Set<Product> productSet);
}
