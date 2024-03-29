package com.JuanGreenGarden.Gardening.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JuanGreenGarden.Gardening.domain.Exceptions.InvalidIdFormatException;
import com.JuanGreenGarden.Gardening.domain.Exceptions.NotFoundEndPoint;
import com.JuanGreenGarden.Gardening.domain.service.OrderService;
import com.JuanGreenGarden.Gardening.persistence.entity.Order;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.OrderDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/**
 * Controlador REST para operaciones relacionadas con las órdenes.
 */
@RestController
@RequestMapping("/api/orders")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Obtiene todas las órdenes.
     * 
     * @return Una respuesta con una lista de todas las órdenes.
     */
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    /**
     * Obtiene una orden por su ID.
     * 
     * @param orderId El ID de la orden.
     * @return Una respuesta con la orden correspondiente al ID especificado.
     * @throws NotFoundEndPoint Si no se encuentra ninguna orden con el ID especificado.
     * @throws InvalidIdFormatException Si el formato del ID de la orden es inválido.
     */
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable String orderId) {
        try {
            Integer id = Integer.parseInt(orderId);
            Order order = orderService.getOrderById(id);
            if (order != null){
                return new ResponseEntity<>(order, HttpStatus.OK);
            } else {
                throw new NotFoundEndPoint("Order with ID " + id + " not found");
            }
        } catch (NumberFormatException e) {
            throw new InvalidIdFormatException("Invalid format for order ID: " + orderId);
        }
    }


    /**
     * Obtiene las órdenes retrasadas.
     * 
     * @return Una respuesta con una lista de las órdenes retrasadas.
     */
    @GetMapping("/delayed")
    public ResponseEntity<List<Object[]>> getDelayedOrders() {
        List<Object[]> delayedOrders = orderService.getDelayedOrders();
        return new ResponseEntity<>(delayedOrders, HttpStatus.OK);
    }


    /**
     * Obtiene las órdenes entregadas temprano.
     * 
     * @return Una respuesta con una lista de las órdenes entregadas temprano.
     */
    @GetMapping("/delivered-early")
    public ResponseEntity<List<Object[]>> getOrdersDeliveredEarly() {
        List<Object[]> orders = orderService.getOrdersDeliveredEarly();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    /**
     * Obtiene las órdenes rechazadas en el año 2009.
     * 
     * @return Una respuesta con una lista de las órdenes rechazadas en el año 2009.
     */
    @GetMapping("/rejected-in-2009")
    public ResponseEntity<List<Order>> getRejectedOrdersIn2009() {
        List<Order> rejectedOrders = orderService.getRejectedOrdersIn2009();
        return new ResponseEntity<>(rejectedOrders, HttpStatus.OK);
    }

    /**
     * Obtiene las órdenes entregadas en enero.
     * 
     * @return Una respuesta con una lista de las órdenes entregadas en enero.
     */
    @GetMapping("/delivered-in-january")
    public ResponseEntity<List<Order>> getOrdersDeliveredInJanuary() {
        List<Order> orders = orderService.getOrdersDeliveredInJanuary();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    /**
     * Endpoint para obtener los nombres de los clientes con entregas tardías.
     *
     * @return ResponseEntity con la lista de nombres de clientes y el estado HTTP correspondiente.
     */
    @GetMapping("/late-delivery")
    public ResponseEntity<List<String>> getClientesEntregaTardia() {
        List<String> clientesEntregaTardia = orderService.findCustomersWithDelayedOrders();
        return new ResponseEntity<>(clientesEntregaTardia, HttpStatus.OK);
    }

    /**
     * Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.
     *
     * @return Lista de las diferentes gamas de producto que ha comprado cada cliente.
     */
    @GetMapping("/product-lines-purchased")
    public ResponseEntity<List<String>> findAllProductLinesByCustomers() {
        List<String> productLines = orderService.findAllProductLinesByCustomers();
        return new ResponseEntity<>(productLines, HttpStatus.OK);
    }
}
