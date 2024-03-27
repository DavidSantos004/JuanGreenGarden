package com.JuanGreenGarden.Gardening.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.ProductLineRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.ProductLine;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.ProductLineDTO;

/**
 * Servicio para operaciones relacionadas con las líneas de producto.
 */
@Service
public class ProductLineService {

    private final ProductLineRepository productLineRepository;

    @Autowired
    public ProductLineService(ProductLineRepository productLineRepository) {
        this.productLineRepository = productLineRepository;
    }

    /**
     * Elimina una línea de producto por su nombre.
     * 
     * @param productLine El nombre de la línea de producto a eliminar.
     */
    public void deleteProductLine(String productLine) {
        productLineRepository.deleteById(productLine);
    }

    /**
     * Obtiene todas las líneas de producto.
     * 
     * @return Una lista de todas las líneas de producto.
     */
    public List<ProductLineDTO> getAllProductLines() {
        return productLineRepository.findAll().stream()
                .map(ProductLine::toDTO)
                .toList();
    }   

    /**
     * Obtiene una línea de producto por su nombre.
     * 
     * @param productLine El nombre de la línea de producto.
     * @return La línea de producto correspondiente al nombre especificado.
     */
    public ProductLine getProductLine(String productLine) {
        return productLineRepository.findByProductLine(productLine);
    }
}
