package com.JuanGreenGarden.Gardening.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

    /**
     * Encuentra los productos que no están incluidos en ninguna orden.
     *
     * @return Lista de productos que no están en órdenes.
     */
    public List<Product> findProductsNotInOrders() {
        return productRepository.findProductsNotInOrders();
    }


    /**
     * Encuentra el precio de venta del producto más caro y más barato.
     *
     * @return Un arreglo donde el primer elemento es el producto más caro y el segundo es el producto más barato.
     */
    public Product[] findMinMaxProductPrice() {
        Product[] result = new Product[2];
        Page<Product> highestPriceProducts = productRepository.findProductsWithHighestPrice(PageRequest.of(0, 1));
        Page<Product> lowestPriceProducts = productRepository.findProductsWithLowestPrice(PageRequest.of(0, 1));
        result[0] = highestPriceProducts.getContent().isEmpty() ? null : highestPriceProducts.getContent().get(0);
        result[1] = lowestPriceProducts.getContent().isEmpty() ? null : lowestPriceProducts.getContent().get(0);
        return result;
    }

    /**
     * Encuentra los 20 productos más vendidos.
     * @return Lista de los 20 productos más vendidos.
     */
    public List<Object[]> findTop20BestSellingProducts() {
        Pageable pageable = PageRequest.of(0, 20); // Paginación para obtener solo los primeros 20 resultados
        return productRepository.findTop20BestSellingProducts(pageable);
    }

    /**
     * Encuentra los productos que no están presentes en ningún pedido.
     *
     * @return Lista de productos que no están presentes en ningún pedido.
     */
    public List<Product> findProductsNotInOrderss() {
        return productRepository.findProductsNotInOrders();
    }
}
