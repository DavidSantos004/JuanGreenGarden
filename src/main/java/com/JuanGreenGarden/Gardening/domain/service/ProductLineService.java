package com.JuanGreenGarden.Gardening.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.ProductLineRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.ProductLine;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.ProductLineDTO;

@Service
public class ProductLineService {

    private final ProductLineRepository productLineRepository;

    @Autowired
    public ProductLineService(ProductLineRepository productLineRepository) {
        this.productLineRepository = productLineRepository;
    }

    public void deleteProductLine(String productLine) {
        productLineRepository.deleteById(productLine);
    }

    public List<ProductLineDTO> getAllProductLines() {
        return productLineRepository.findAll().stream()
                .map(ProductLine::toDTO)
                .toList();
    }   

    public ProductLine getProductLine(String productLine) {
        return productLineRepository.findByProductLine(productLine);
    }
}
