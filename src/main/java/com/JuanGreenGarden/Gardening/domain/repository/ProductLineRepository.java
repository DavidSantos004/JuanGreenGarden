package com.JuanGreenGarden.Gardening.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JuanGreenGarden.Gardening.persistence.entity.ProductLine;

@Repository
public interface ProductLineRepository extends JpaRepository<ProductLine, String>{
    ProductLine findByProductLine(String productLine);

}
