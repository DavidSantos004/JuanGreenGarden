package com.JuanGreenGarden.Gardening.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.OrderRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.Order;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.OrderDTO;

/**
 * Servicio para la entidad Order.
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Obtiene todas las órdenes.
     * 
     * @return Una lista de todas las órdenes.
     */
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(Order::toDTO)
                .toList();
    }

    /**
     * Obtiene una orden por su identificador.
     * 
     * @param orderId El identificador de la orden.
     * @return La orden correspondiente al identificador especificado.
     */
    public Order getOrderById(Integer orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    /**
     * Obtiene las órdenes retrasadas.
     * 
     * @return Una lista de arrays de objetos que contienen los detalles de las órdenes retrasadas.
     */
    public List<Object[]> getDelayedOrders() {
        return orderRepository.findDelayedOrders();
    }

    /**
     * Obtiene las órdenes entregadas antes de tiempo.
     * 
     * @return Una lista de arrays de objetos que contienen los detalles de las órdenes entregadas antes de tiempo.
     */
    public List<Object[]> getOrdersDeliveredEarly() {
        return orderRepository.findOrdersDeliveredEarly();
    }

    /**
     * Obtiene las órdenes rechazadas en el año 2009.
     * 
     * @return Una lista de órdenes rechazadas en el año 2009.
     */
    public List<Order> getRejectedOrdersIn2009() {
        return orderRepository.findRejectedOrdersIn2009();
    }

    /**
     * Obtiene las órdenes entregadas en enero.
     * 
     * @return Una lista de órdenes entregadas en enero.
     */
    public List<Order> getOrdersDeliveredInJanuary() {
        return orderRepository.findOrdersDeliveredInJanuary();
    }

    /**
     * Busca los nombres de clientes con pedidos entregados tarde.
     *
     * @return Lista de nombres de clientes con pedidos entregados tarde.
     */
    public List<String> findCustomersWithDelayedOrders() {
        return orderRepository.findCustomersWithDelayedOrders();
    }

    /**
     * Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.
     *
     * @return Lista de las diferentes gamas de producto que ha comprado cada cliente.
     */
    public List<String> findAllProductLinesByCustomers() {
        return orderRepository.findAllProductLinesByCustomers();
    }
}

