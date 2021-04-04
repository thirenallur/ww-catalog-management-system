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

import com.thippeshhirenallur.catalogmanagementplatform.entity.Product;
import com.thippeshhirenallur.catalogmanagementplatform.entity.SubCategory;
import com.thippeshhirenallur.catalogmanagementplatform.service.ProductService;
import com.thippeshhirenallur.catalogmanagementplatform.service.SubCategoryService;
import io.swagger.annotations.Api;
@RestController
@RequestMapping("/products")
@Api(tags= {"Product API's"} ) 
public class ProductController {
	
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping(value = "/{categoryId}/{subCategoryId}")
	public ResponseEntity<List<Product>> getProducts(@PathVariable final Integer categoryId, @PathVariable final Integer subCategoryId) {
		List<Product> products = productService.getProductsBySubCategoryAndCategory(categoryId, subCategoryId);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@PostMapping(value = "/{categoryId}/{subCategoryId}")
	public ResponseEntity<Product> addProduct(@RequestBody final Product product,@PathVariable final Integer categoryId, @PathVariable final Integer subCategoryId ) {
		Product productAdded = productService.addProduct(categoryId, subCategoryId, product);
		return new ResponseEntity<>(productAdded, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{categoryId}/{subCategoryId}/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable final Integer categoryId, @PathVariable final Integer subCategoryId,@PathVariable final Integer productId,
			@RequestBody final Product product) {
		Product productToUpdate = productService.updateProduct(categoryId, subCategoryId, productId, product);
		return new ResponseEntity<>((productToUpdate), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{categoryId}/{subCategoryId}/{productId}")
	public ResponseEntity<Product> deleteProduct(@PathVariable final Integer categoryId,@PathVariable final Integer subCategoryId,@PathVariable final Integer productId) {
		Product productDeleted = productService.deleteProduct(categoryId, subCategoryId, productId);
		return new ResponseEntity<>((productDeleted), HttpStatus.OK);
	}
}
