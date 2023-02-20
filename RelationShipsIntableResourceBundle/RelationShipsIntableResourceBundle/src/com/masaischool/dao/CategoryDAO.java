package com.masaischool.dao;

import java.util.List;

import com.masaischool.dto.Category;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public interface CategoryDAO {
	public void addCategory(Category category) throws SomeThingWrongException;
	public void updateCategory(Category category) throws SomeThingWrongException;
	public void deleteCategory(Integer categoryId) throws SomeThingWrongException;
	public List<Category> getAllCategories() throws SomeThingWrongException, NoRecordFoundException;
	public List<Category> getCategoriesByName(String name) throws SomeThingWrongException, NoRecordFoundException;
	public Category getCategoryById(Integer categoryId) throws SomeThingWrongException, NoRecordFoundException;
}
