package com.JuanGreenGarden.Gardening.domain.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    /**
     * Encuentra los productos que no están incluidos en ninguna orden.
     *
     * @return Lista de productos que no están en órdenes.
     */
    @Query("SELECT p FROM Product p WHERE NOT EXISTS (SELECT od FROM OrderDetail od WHERE od.productField = p)")
    List<Product> findProductsNotInOrders();


    /**
     * Busca el producto con el precio de venta más alto.
     *
     * @return El producto con el precio de venta más alto.
     */
    @Query("SELECT p FROM Product p ORDER BY p.buyPrice DESC")
    Page<Product> findProductsWithHighestPrice(Pageable pageable);

    /**
     * Busca el producto con el precio de venta más bajo.
     *
     * @return El producto con el precio de venta más bajo.
     */
    @Query("SELECT p FROM Product p ORDER BY p.buyPrice ASC")
    Page<Product> findProductsWithLowestPrice(Pageable pageable);

    /**
     * Encuentra los productos más vendidos.
     * @param pageable Objeto Pageable para la paginación y ordenamiento de resultados.
     * @return Lista de productos más vendidos.
     */
    @Query("SELECT od.productField, SUM(od.quantityOrdered) AS totalUnitsSold " +
           "FROM OrderDetail od " +
           "GROUP BY od.productField " +
           "ORDER BY totalUnitsSold DESC")
    List<Object[]> findTop20BestSellingProducts(Pageable pageable);

    /**
     * Busca los productos que no están incluidos en ningún detalle de pedido.
     *
     * @return Lista de productos que no están en ningún detalle de pedido.
     */
    @Query("SELECT p FROM Product p WHERE p.productCode NOT IN (SELECT od.productField.productCode FROM OrderDetail od)")
    List<Product> findProductsNotInOrderss();
}
