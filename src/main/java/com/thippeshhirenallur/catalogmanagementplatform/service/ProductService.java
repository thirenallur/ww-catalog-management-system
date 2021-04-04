package com.thippeshhirenallur.catalogmanagementplatform.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.thippeshhirenallur.catalogmanagementplatform.entity.Product;

@Service
public interface ProductService {
	
	public List<Product> getProductsBySubCategoryAndCategory(Integer categoryId, Integer subCategoryId);
	
	public Product addProduct(Integer categoryId,Integer subCategoryId, Product product);
	
	@Transactional
	public Product updateProduct(Integer categoryId,Integer subCategoryId, Integer productId, Product product);
	
	public Product deleteProduct(Integer categoryId,Integer subCategoryId, Integer productId);
}
