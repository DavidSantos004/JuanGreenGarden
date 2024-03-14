package com.JuanGreenGarden.Gardening.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.ProductRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.Product;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductByCode(String productCode) {
        return productRepository.findById(productCode).orElse(null);
    }

    public Product createOrUpdateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(String productCode) {
        productRepository.deleteById(productCode);
    }
}
