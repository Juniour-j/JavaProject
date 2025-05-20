package com.services;

import com.models.*;
import com.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@ComponentScan(basePackages = "com.repository.ProductRepository")
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> searchProducts(String text) {
        return productRepository.findByNameContainingIgnoreCaseOrCategory_NameContainingIgnoreCase(text, text);
    }
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}