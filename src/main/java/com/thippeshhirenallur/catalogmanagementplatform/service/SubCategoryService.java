package com.thippeshhirenallur.catalogmanagementplatform.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.thippeshhirenallur.catalogmanagementplatform.entity.SubCategory;

@Service
public interface SubCategoryService {
	
	public List<SubCategory> getSubCategoriesByCategory(Integer categoryId);
	
	public SubCategory addSubCategory(Integer categoryId, SubCategory subCategory);
	
	@Transactional
	public SubCategory updateSubCategory(Integer categoryId,Integer subCategoryId, SubCategory subCategory);
	
	public SubCategory deleteSubCategory(Integer categoryId,Integer subCategoryId);
}
