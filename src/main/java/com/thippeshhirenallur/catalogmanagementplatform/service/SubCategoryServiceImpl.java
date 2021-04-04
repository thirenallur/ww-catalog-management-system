package com.thippeshhirenallur.catalogmanagementplatform.service;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thippeshhirenallur.catalogmanagementplatform.entity.Category;
import com.thippeshhirenallur.catalogmanagementplatform.entity.SubCategory;
import com.thippeshhirenallur.catalogmanagementplatform.exception.ResourceNotFoundException;
import com.thippeshhirenallur.catalogmanagementplatform.repository.CategoryRepository;
import com.thippeshhirenallur.catalogmanagementplatform.repository.SubCategoryRepository;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public SubCategory addSubCategory(Integer categoryId, SubCategory subCategory) {
		return subCategoryRepository.save(subCategory);
	}

	public SubCategory updateSubCategory(Integer categoryId, Integer subCategoryId, SubCategory subCategory) {
		List<SubCategory> subCategories = getSubCategoriesByCategory(categoryId);
		if(subCategories == null)
			throw new ResourceNotFoundException("subCategories Not Found for a given input data");
		SubCategory subCategoryToUpdate = getSubCategory(subCategoryId, subCategories);
		if(subCategoryToUpdate == null)
			throw new ResourceNotFoundException("subCategoryToUpdate Not Found for a given input data");
		if (subCategoryToUpdate != null) {
			subCategoryToUpdate.setCategoryId(subCategory.getCategoryId());
			subCategoryToUpdate.setSubCategoryName(subCategory.getSubCategoryName());
		}
		return subCategoryToUpdate;
	}

	public SubCategory deleteSubCategory(Integer categoryId, Integer subCategoryId) {
		List<SubCategory> subCategories = getSubCategoriesByCategory(categoryId);
		if(subCategories == null)
			throw new ResourceNotFoundException("subCategories Not Found for a given input data");
		SubCategory subCategoryToDelete = getSubCategory(subCategoryId, subCategories);
		if(subCategoryToDelete == null)
			throw new ResourceNotFoundException("subCategoryToDelete Not Found for a given input data");
		if (subCategoryToDelete != null)
			subCategoryRepository.delete(subCategoryToDelete);
		return subCategoryToDelete;
	}

	private SubCategory getSubCategory(Integer subCategoryId, List<SubCategory> subCategories) {
		for (int x = 0; x < subCategories.size(); x++) {
			if (subCategories.get(x).getSubCategoryId() == subCategoryId)
				return subCategories.get(x);
		}
		return null;
	}

	public List<SubCategory> getSubCategoriesByCategory(Integer categoryId) {
		List<Category> categories = StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		for (int x = 0; x < categories.size(); x++) {
			if (categories.get(x).getCategoryId() == categoryId)
				return categories.get(x).getSubCategories();
		}
		return null;
	}
}
