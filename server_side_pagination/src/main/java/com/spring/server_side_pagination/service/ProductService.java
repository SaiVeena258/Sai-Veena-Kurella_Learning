package com.spring.server_side_pagination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.spring.server_side_pagination.model.Product;
import com.spring.server_side_pagination.repo.ProductRepo;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepository;
    
    public Page<Product> getProducts(
            String name, String category, Double minPrice, Double maxPrice, 
            String sortBy, String sortDirection, int page, int size) {
        
        Pageable pageable = PageRequest.of(page, size, 
            sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending());

        if (category != null && minPrice != null && maxPrice != null) {
            return productRepository.findByCategoryIgnoreCaseAndPriceBetween(category, minPrice, maxPrice, pageable);
        } else if (category != null) {
            return productRepository.findByCategoryIgnoreCase(category, pageable);
        } else if (name != null) {
            return productRepository.findByNameContainingIgnoreCase(name, pageable);
        } else if (minPrice != null && maxPrice != null) {
            return productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
        } else {
            return productRepository.findAll(pageable);
        }
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }
}
