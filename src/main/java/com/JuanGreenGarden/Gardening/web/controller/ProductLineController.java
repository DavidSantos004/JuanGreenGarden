package com.JuanGreenGarden.Gardening.web.controller;


import com.JuanGreenGarden.Gardening.domain.Exceptions.NotFoundEndPoint;
import com.JuanGreenGarden.Gardening.domain.service.ProductLineService;
import com.JuanGreenGarden.Gardening.persistence.entity.ProductLine;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.ProductLineDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productlines")
public class ProductLineController {

    private final ProductLineService productLineService;

    @Autowired
    public ProductLineController(ProductLineService productLineService) {
        this.productLineService = productLineService;
    }

    @GetMapping
    public ResponseEntity<List<ProductLineDTO>> getAllProductLines() {
        List<ProductLineDTO> productLines = productLineService.getAllProductLines();
        return new ResponseEntity<>(productLines, HttpStatus.OK);
    }

    @GetMapping("/{productLine}")
    public ResponseEntity<ProductLine> getProductLine(@PathVariable String productLine) {
        ProductLine productLineObj = productLineService.getProductLine(productLine);
        if ( productLineObj != null){
            return new ResponseEntity<>(productLineObj, HttpStatus.OK);
        } else{
            throw new NotFoundEndPoint("ProductLine Whit ID" + productLine + " Not found");
        }
    }

    
}

