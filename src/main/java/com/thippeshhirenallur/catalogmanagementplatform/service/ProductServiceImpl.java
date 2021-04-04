package com.thippeshhirenallur.catalogmanagementplatform.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thippeshhirenallur.catalogmanagementplatform.entity.Category;
import com.thippeshhirenallur.catalogmanagementplatform.entity.Product;
import com.thippeshhirenallur.catalogmanagementplatform.entity.SubCategory;
import com.thippeshhirenallur.catalogmanagementplatform.exception.ResourceNotFoundException;
import com.thippeshhirenallur.catalogmanagementplatform.repository.CategoryRepository;
import com.thippeshhirenallur.catalogmanagementplatform.repository.ProductRepository;
import com.thippeshhirenallur.catalogmanagementplatform.repository.SubCategoryRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProductsBySubCategoryAndCategory(Integer categoryId, Integer subCategoryId) {
		List<SubCategory> subCategories = getSubCategoriesByCategory(categoryId);
		if(subCategories == null)
			throw new ResourceNotFoundException("subCategories Not Found for a given input data");
		SubCategory subCategory = getSubCategory(subCategoryId, subCategories);
		if(subCategory == null)
			throw new ResourceNotFoundException("subCategory Not Found for a given input data");
		return subCategory.getProducts();
	}

	public Product addProduct(Integer categoryId, Integer subCategoryId, Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Integer categoryId, Integer subCategoryId, Integer productId, Product product) {
		List<Product> products = getProductsBySubCategoryAndCategory(categoryId, subCategoryId);
		Product productToUpdate = getProduct(productId, products);
		if(productToUpdate == null)
			throw new ResourceNotFoundException("productToUpdate Not Found for a given input data");
		productToUpdate.setCategoryId(product.getCategoryId());
		productToUpdate.setCurrency(product.getCurrency());
		productToUpdate.setDescription(product.getDescription());
		productToUpdate.setProductName(product.getProductName());
		productToUpdate.setSubcategoryId(product.getSubcategoryId());
		return productToUpdate;
	}

	public Product getProduct(Integer productId, List<Product> products) {
		for (int x = 0; x < products.size(); x++) {
			if (products.get(x).getProductId() == productId)
				return products.get(x);
		}
		return null;
	}

	public Product deleteProduct(Integer categoryId, Integer subCategoryId, Integer productId) {
		List<Product> products = getProductsBySubCategoryAndCategory(categoryId, subCategoryId);
		Product productToDelete = getProduct(productId, products);
		if (productToDelete != null)
			productRepository.delete(productToDelete);
		return productToDelete;
	}

	public SubCategory getSubCategory(Integer subCategoryId, List<SubCategory> subCategories) {
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
