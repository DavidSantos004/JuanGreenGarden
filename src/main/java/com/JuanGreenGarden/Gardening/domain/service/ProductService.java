package com.JuanGreenGarden.Gardening.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.ProductRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.Product;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.ProductDTO;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductByCode(String productCode) {
        return productRepository.findById(productCode).orElse(null);
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(Product::toDTO)
                .toList();
    }   
}
