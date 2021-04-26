package com.thippeshhirenallur.catalogmanagementplatform.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.thippeshhirenallur.catalogmanagementplatform.entity.Category;

@Service
public interface CategoryService {
	
	public List<Category> getCategories();
	public List<Category> getCategoriesByCategoryName(String categoryName);

	public Category getCategory(Integer categoryId);
	
	public Category addCategory(Category category);

	public Category deleteCategory(Integer categoryId);

	@Transactional
	public Category updateCategory(Integer categoryId, Category category);
	
}
