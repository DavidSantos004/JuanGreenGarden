package com.JuanGreenGarden.Gardening.domain.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JuanGreenGarden.Gardening.persistence.entity.Order;

/**
 * Repositorio para la entidad Order.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    /**
     * Encuentra las órdenes retrasadas.
     * 
     * @return Una lista de arrays de objetos que contienen el número de orden, número de cliente, fecha requerida y fecha de envío de las órdenes retrasadas.
     */
    @Query("SELECT o.orderNumber, o.customerField.customerNumber, o.requiredDate, o.shippedDate FROM Order o WHERE o.status <> 'Shipped' AND o.requiredDate < CURRENT_DATE")
    List<Object[]> findDelayedOrders();

    /**
     * Encuentra las órdenes entregadas antes de tiempo.
     * 
     * @return Una lista de arrays de objetos que contienen el número de orden, número de cliente, fecha requerida y fecha de envío de las órdenes entregadas antes de tiempo.
     */
    @Query("SELECT o.orderNumber, o.customerField.customerNumber, o.requiredDate, o.shippedDate FROM Order o WHERE o.shippedDate < FUNCTION('DATEADD', DAY, 2, o.requiredDate)")
    List<Object[]> findOrdersDeliveredEarly();

    /**
     * Encuentra las órdenes rechazadas en el año 2009.
     * 
     * @return Una lista de órdenes rechazadas en el año 2009.
     */
    @Query("SELECT o FROM Order o WHERE o.status = 'Rechazado' AND YEAR(o.orderDate) = 2009")
    List<Order> findRejectedOrdersIn2009();

    /**
     * Encuentra las órdenes entregadas en enero.
     * 
     * @return Una lista de órdenes entregadas en enero.
     */
    @Query("SELECT o FROM Order o WHERE MONTH(o.shippedDate) = 1")
    List<Order> findOrdersDeliveredInJanuary();
}

