package com.JuanGreenGarden.Gardening.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JuanGreenGarden.Gardening.persistence.entity.ProductLine;

/**
 * Repositorio para la entidad ProductLine.
 */
@Repository
public interface ProductLineRepository extends JpaRepository<ProductLine, String> {
    
    /**
     * Busca una línea de producto por su nombre.
     * 
     * @param productLine El nombre de la línea de producto.
     * @return La línea de producto correspondiente al nombre especificado.
     */
    ProductLine findByProductLine(String productLine);

}

