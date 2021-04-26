package com.thippeshhirenallur.catalogmanagementplatform.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.thippeshhirenallur.catalogmanagementplatform.entity.Category;
import java.util.*;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    public List <Category> findByCategoryName(String categoryName);
}
}
