package com.repository;
import com.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
    List<Product> findByCategory(Category category);
    List<Product> findByCategoryId(Long categoryId);
    List<Product> findByNameContainingIgnoreCaseOrCategory_NameContainingIgnoreCase(String name, String categoryName);

}

