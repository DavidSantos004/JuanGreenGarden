package com.JuanGreenGarden.Gardening.web.controller;


import com.JuanGreenGarden.Gardening.domain.service.ProductLineService;
import com.JuanGreenGarden.Gardening.persistence.entity.ProductLine;
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
    public ResponseEntity<List<ProductLine>> getAllProductLines() {
        List<ProductLine> productLines = productLineService.getAllProductLines();
        return new ResponseEntity<>(productLines, HttpStatus.OK);
    }

    @GetMapping("/{productLine}")
    public ResponseEntity<ProductLine> getProductLine(@PathVariable String productLine) {
        ProductLine productLineObj = productLineService.getProductLine(productLine);
        return productLineObj != null ?
                new ResponseEntity<>(productLineObj, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ProductLine> createProductLine(@RequestBody ProductLine productLine) {
        ProductLine createdProductLine = productLineService.createOrUpdateProductLine(productLine);
        return new ResponseEntity<>(createdProductLine, HttpStatus.CREATED);
    }

    @PutMapping("/{productLine}")
    public ResponseEntity<ProductLine> updateProductLine(@PathVariable String productLine, @RequestBody ProductLine productLineDetails) {
        productLineDetails.setProductLine(productLine);
        ProductLine updatedProductLine = productLineService.createOrUpdateProductLine(productLineDetails);
        return new ResponseEntity<>(updatedProductLine, HttpStatus.OK);
    }

    @DeleteMapping("/{productLine}")
    public ResponseEntity<Void> deleteProductLine(@PathVariable String productLine) {
        productLineService.deleteProductLine(productLine);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

