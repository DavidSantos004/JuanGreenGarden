package com.JuanGreenGarden.Gardening.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JuanGreenGarden.Gardening.persistence.entity.Product;

/**
 * Repositorio para la entidad Product.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    /**
     * Busca productos por la línea de producto y la cantidad en stock.
     * 
     * @param productLine      La línea de producto.
     * @param quantityInStock  La cantidad mínima en stock.
     * @return                 Una lista de productos que coinciden con los criterios especificados.
     */
    List<Product> findByProductLineFieldProductLineAndQuantityInStockGreaterThan(String productLine, int quantityInStock);

}
