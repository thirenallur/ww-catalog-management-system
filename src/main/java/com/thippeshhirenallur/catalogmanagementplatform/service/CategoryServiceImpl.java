package com.thippeshhirenallur.catalogmanagementplatform.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thippeshhirenallur.catalogmanagementplatform.entity.Category;
import com.thippeshhirenallur.catalogmanagementplatform.exception.ResourceNotFoundException;
import com.thippeshhirenallur.catalogmanagementplatform.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	public List<Category> getCategories() {
		return StreamSupport.
				stream(categoryRepository.
						findAll().
						spliterator(), false).
				collect(Collectors.toList());
	}

	public Category getCategory(Integer categoryId) {
		return categoryRepository.
				findById(categoryId).
				orElseThrow(() -> 
				new ResourceNotFoundException("Category Not Found with ID "+categoryId));
	}

	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	public Category deleteCategory(Integer categoryId) {
		Category categoryToDelete = getCategory(categoryId);
		categoryRepository.delete(categoryToDelete);
		return categoryToDelete;
	}

	@Transactional
	public Category updateCategory(Integer categoryId, Category category) {
		Category categoryToUpdate = getCategory(categoryId);
		categoryToUpdate.setCategoryName(category.getCategoryName());
		return categoryToUpdate;
	}

	public List<Category> getCategoriesByCategoryName(String categoryName) {
		return StreamSupport.
				stream(categoryRepository.
						findByCategoryName(categoryName).
						spliterator(), false).
				collect(Collectors.toList());
	}

}
