package com.JuanGreenGarden.Gardening.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.JuanGreenGarden.Gardening.domain.Exceptions.NotFoundEndPoint;
import com.JuanGreenGarden.Gardening.domain.service.ProductService;
import com.JuanGreenGarden.Gardening.persistence.entity.Product;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.ProductDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/**
 * Controlador REST para operaciones relacionadas con los productos.
 */
@RestController
@RequestMapping("/api/products")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Obtiene todos los productos.
     * 
     * @return Una respuesta con una lista de todos los productos.
     */
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Obtiene un producto por su código.
     * 
     * @param productCode El código del producto.
     * @return            Una respuesta con el producto correspondiente al código especificado.
     * @throws NotFoundEndPoint Si no se encuentra ningún producto con el código especificado.
     */
    @GetMapping("/{productCode}")
    public ResponseEntity<Product> getProductByCode(@PathVariable String productCode) {
        Product product = productService.getProductByCode(productCode);
        if (product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            throw new NotFoundEndPoint("Product with ID"+ productCode + " not Found");
        }
    }

    /**
     * Obtiene todos los productos de la línea "Ornamentales" con una cantidad en stock mayor a 100.
     * 
     * @return Una lista de productos que cumplen con los criterios especificados.
     */
    @GetMapping("/products-ornamentales")
    public List<Product> getOrnamentalesWithStockOver100() {
        return productService.getProductsByProductLineAndQuantityInStock("Ornamentales", 100);
    }


    @GetMapping("/not-in-orders")
    public ResponseEntity<List<Product>> getProductsNotInOrders() {
        List<Product> products = productService.findProductsNotInOrders();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
