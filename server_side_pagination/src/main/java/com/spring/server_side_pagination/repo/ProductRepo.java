package com.spring.server_side_pagination.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.server_side_pagination.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
	Page<Product> findByCategoryIgnoreCase(String category, Pageable pageable);
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Product> findByPriceBetween(double minPrice, double maxPrice, Pageable pageable);
    Page<Product> findByCategoryIgnoreCaseAndPriceBetween(String category, double minPrice, double maxPrice, Pageable pageable);
}
