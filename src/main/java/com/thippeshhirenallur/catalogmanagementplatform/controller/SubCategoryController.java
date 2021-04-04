package com.thippeshhirenallur.catalogmanagementplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.thippeshhirenallur.catalogmanagementplatform.entity.SubCategory;
import com.thippeshhirenallur.catalogmanagementplatform.service.SubCategoryService;
import io.swagger.annotations.Api;
@RestController
@RequestMapping("/subcategories")
@Api(tags= {"SubCategory API's"} ) 
public class SubCategoryController {

	private final SubCategoryService subCategoryService;
	
	@Autowired
	public SubCategoryController(SubCategoryService subCategoryService) {
		super();
		this.subCategoryService = subCategoryService;
	}
	
	@GetMapping(value = "/{categoryId}")
	public ResponseEntity<List<SubCategory>> getSubCategories(@PathVariable final Integer categoryId) {
		List<SubCategory> subCategories = subCategoryService.getSubCategoriesByCategory(categoryId);
		return new ResponseEntity<>(subCategories, HttpStatus.OK);
	}
	
	@PostMapping(value = "/{categoryId}")
	public ResponseEntity<SubCategory> addSubCategory(@RequestBody final SubCategory subCategory,@PathVariable final Integer categoryId ) {
		SubCategory subCategoryAdded = subCategoryService.addSubCategory(categoryId, subCategory);
		return new ResponseEntity<>(subCategoryAdded, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{categoryId}/{subCategoryId}")
	public ResponseEntity<SubCategory> updateSubCategory(@PathVariable final Integer categoryId, @PathVariable final Integer subCategoryId,
			@RequestBody final SubCategory subCategory) {
		SubCategory subCategoryToUpdate = subCategoryService.updateSubCategory(categoryId, subCategoryId, subCategory);
		return new ResponseEntity<>((subCategoryToUpdate), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{categoryId}/{subCategoryId}")
	public ResponseEntity<SubCategory> deleteSubCategory(@PathVariable final Integer categoryId,@PathVariable final Integer subCategoryId) {
		SubCategory subCategory = subCategoryService.deleteSubCategory(categoryId, subCategoryId);
		return new ResponseEntity<>((subCategory), HttpStatus.OK);
	}
}
