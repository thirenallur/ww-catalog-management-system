package com.thippeshhirenallur.catalogmanagementplatform.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thippeshhirenallur.catalogmanagementplatform.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
