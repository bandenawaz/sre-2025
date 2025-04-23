package com.example.ecommerce.ecommerce_api.services;

import com.example.ecommerce.ecommerce_api.model.Product;
import com.example.ecommerce.ecommerce_api.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Add a product
    @Transactional
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    //get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //get product by id
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    //update product
    @Transactional
    public Product updateProduct(Long id,Product productDetails) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(productDetails.getName());
                    existingProduct.setDescription(productDetails.getDescription());
                    existingProduct.setPrice(productDetails.getPrice());
                    existingProduct.setStock(productDetails.getStock());

                    //save the product
                    return productRepository.save(existingProduct);

                }).orElseThrow(() -> {
                    throw new RuntimeException("Product not found with id: " + id);
                });

    }

    //delete product
    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
