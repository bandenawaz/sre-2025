package com.example.ecommerce.ecommerce_api.repositories;

import com.example.ecommerce.ecommerce_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
