package com.JuanGreenGarden.Gardening.web.controller;

import com.JuanGreenGarden.Gardening.domain.Exceptions.NotFoundEndPoint;
import com.JuanGreenGarden.Gardening.domain.service.ProductLineService;
import com.JuanGreenGarden.Gardening.persistence.entity.ProductLine;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.ProductLineDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para operaciones relacionadas con las líneas de producto.
 */
@RestController
@RequestMapping("/api/productlines")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class ProductLineController {

    private final ProductLineService productLineService;

    @Autowired
    public ProductLineController(ProductLineService productLineService) {
        this.productLineService = productLineService;
    }

    /**
     * Obtiene todas las líneas de producto.
     * 
     * @return Una respuesta con una lista de todas las líneas de producto.
     */
    @GetMapping
    public ResponseEntity<List<ProductLineDTO>> getAllProductLines() {
        List<ProductLineDTO> productLines = productLineService.getAllProductLines();
        return new ResponseEntity<>(productLines, HttpStatus.OK);
    }

    /**
     * Obtiene una línea de producto por su nombre.
     * 
     * @param productLine El nombre de la línea de producto.
     * @return Una respuesta con la línea de producto correspondiente al nombre especificado.
     * @throws NotFoundEndPoint Si no se encuentra ninguna línea de producto con el nombre especificado.
     */
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
