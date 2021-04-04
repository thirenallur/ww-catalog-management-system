package com.thippeshhirenallur.catalogmanagementplatform.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;
import com.thippeshhirenallur.catalogmanagementplatform.entity.Category;
import com.thippeshhirenallur.catalogmanagementplatform.service.CategoryService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/categories")
@Api(tags= {"Category API's"} ) 
public class CategoryController {
	
	private final CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> getCategories() {
		List<Category> categories = categoryService.getCategories();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@GetMapping(value = "categoryName/categoryName")
	public ResponseEntity<?> getCategoriesByName(@RequestParam  final String categoryName) {
		List<Category> categories = categoryService.getCategories();
		Category category = null;
		for (int x = 0; x<categories.size();x++)
			if(categories.get(x).getCategoryName().equals(categoryName))
				category = categories.get(x);
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		Integer total_number_products =0;
		if(category!=null && category.getSubCategories() !=null)
		for(int x = 0; x < category.getSubCategories().size();x++)
			total_number_products+=category.getSubCategories().get(x).getProducts().size();
		    hmap.put("number_of_products", total_number_products);
		    hmap.put("category", category);
		return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
	}
	
	@GetMapping(value = "{categoryid}")
	public ResponseEntity<Category> getCategory(@PathVariable final Integer categoryid) {
		Category category = categoryService.getCategory(categoryid);
		return new ResponseEntity<>((category), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Category> addCategory(@RequestBody final Category category) {
		Category categoryAdded = categoryService.addCategory(category);
		return new ResponseEntity<>(categoryAdded, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "{categoryid}")
	public ResponseEntity<Category> deleteCategory(@PathVariable final Integer categoryid) {
		Category category = categoryService.deleteCategory(categoryid);
		return new ResponseEntity<>((category), HttpStatus.OK);
	}
	
	@PutMapping(value = "{categoryid}")
	public ResponseEntity<Category> updateCategory(@PathVariable final Integer categoryid,
			@RequestBody final Category category) {
		Category categoryToUpdate = categoryService.updateCategory(categoryid, category);
		return new ResponseEntity<>((categoryToUpdate), HttpStatus.OK);
	}
}
