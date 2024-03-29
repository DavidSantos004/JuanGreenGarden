package com.JuanGreenGarden.Gardening.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetail;
import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetailId;

/**
 * Repositorio para la entidad OrderDetail.
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
    
    /**
     * Consulta personalizada para obtener el número de productos diferentes en cada pedido.
     *
     * @return Lista de arrays de objetos que contienen el número de pedido y el número de productos diferentes.
     */
    @Query("SELECT o.orderField.orderNumber, COUNT(DISTINCT o.productField) " +
           "FROM OrderDetail o " +
           "GROUP BY o.orderField.orderNumber")
    List<Object[]> countDistinctProductsInOrders();

    /**
     * Consulta personalizada para obtener la suma de la cantidad total de todos los productos en cada pedido.
     *
     * @return Lista de arrays de objetos que contienen el número de pedido y la suma de la cantidad total de productos.
     */
    @Query("SELECT o.orderField.orderNumber, SUM(o.quantityOrdered) " +
           "FROM OrderDetail o " +
           "GROUP BY o.orderField.orderNumber")
    List<Object[]> sumTotalQuantityInOrders();

    /**
     * Encuentra los detalles del pedido filtrados por el código de producto que comienza con el prefijo especificado.
     * @param prefix El prefijo del código de producto.
     * @return Lista de detalles del pedido que coinciden con el criterio de búsqueda.
     */
    @Query("SELECT od FROM OrderDetail od WHERE od.productField.productCode LIKE CONCAT(:prefix, '%')")
    List<OrderDetail> findByProductField_ProductCodeStartingWith(String prefix);

    /**
     * Encuentra los detalles del pedido cuyo total sea mayor que 3000 euros.
     * @return Lista de detalles del pedido que cumplen con el criterio de total mayor a 3000 euros.
     */
    @Query("SELECT od FROM OrderDetail od WHERE od.priceEach * od.quantityOrdered > 3000")
    List<OrderDetail> findOrderDetailsWithTotalGreaterThan3000();
}

