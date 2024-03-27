package com.JuanGreenGarden.Gardening.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.ProductRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.Product;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.ProductDTO;

/**
 * Servicio para operaciones relacionadas con los productos.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Obtiene un producto por su código.
     * 
     * @param productCode El código del producto.
     * @return            El producto correspondiente al código especificado.
     */
    public Product getProductByCode(String productCode) {
        return productRepository.findById(productCode).orElse(null);
    }

    /**
     * Obtiene todos los productos.
     * 
     * @return Una lista de todos los productos.
     */
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(Product::toDTO)
                .toList();
    }

    /**
     * Obtiene productos por la línea de producto y la cantidad en stock.
     * 
     * @param productLine      La línea de producto.
     * @param quantityInStock  La cantidad mínima en stock.
     * @return                 Una lista de productos que coinciden con los criterios especificados.
     */
    public List<Product> getProductsByProductLineAndQuantityInStock(String productLine, int quantityInStock) {
        return productRepository.findByProductLineFieldProductLineAndQuantityInStockGreaterThan(productLine, quantityInStock);
    }

}
