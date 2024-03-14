package com.JuanGreenGarden.Gardening.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.ProductLineRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.ProductLine;

@Service
public class ProductLineService {

    private final ProductLineRepository productLineRepository;

    @Autowired
    public ProductLineService(ProductLineRepository productLineRepository) {
        this.productLineRepository = productLineRepository;
    }

    public List<ProductLine> getAllProductLines() {
        return productLineRepository.findAll();
    }

    public ProductLine getProductLine(String productLine) {
        return productLineRepository.findById(productLine).orElse(null);
    }

    public ProductLine createOrUpdateProductLine(ProductLine productLine) {
        return productLineRepository.save(productLine);
    }

    public void deleteProductLine(String productLine) {
        productLineRepository.deleteById(productLine);
    }
}
