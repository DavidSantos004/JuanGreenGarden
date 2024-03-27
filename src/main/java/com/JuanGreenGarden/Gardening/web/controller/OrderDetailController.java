package com.JuanGreenGarden.Gardening.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JuanGreenGarden.Gardening.domain.Exceptions.DifferentDataTypeException;
import com.JuanGreenGarden.Gardening.domain.Exceptions.NotFoundEndPoint;
import com.JuanGreenGarden.Gardening.domain.service.OrderDetailService;
import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetail;
import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetailId;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.OrderDetailDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/**
 * Controlador REST para operaciones relacionadas con los detalles de órdenes.
 */
@RestController
@RequestMapping("/api/orderdetails")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @Autowired
    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    /**
     * Obtiene todos los detalles de órdenes.
     * 
     * @return Una respuesta con una lista de todos los detalles de órdenes.
     */
    @GetMapping
    public ResponseEntity<List<OrderDetailDTO>> getAllOrderDetails() {
        List<OrderDetailDTO> orderDetails = orderDetailService.getAllOrdersDetail();
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    /**
     * Obtiene un detalle de orden por su número de orden y número de línea.
     * 
     * @param orderNumber    El número de orden.
     * @param orderLineNumber    El número de línea de la orden.
     * @return Una respuesta con el detalle de orden correspondiente.
     * @throws NotFoundEndPoint Si no se encuentra ningún detalle de orden con los números especificados.
     * @throws DifferentDataTypeException Si los números de orden no son valores numéricos válidos.
     */
    @GetMapping("/{orderNumber}/{orderLineNumber}")
    public ResponseEntity<OrderDetail> getOrderDetail(@PathVariable String orderNumber, @PathVariable String orderLineNumber) {
        try {
            Integer number = Integer.parseInt(orderNumber);
            Integer lineNumber = Integer.parseInt(orderLineNumber);

            OrderDetailId orderDetailId = new OrderDetailId(number, lineNumber);
            OrderDetail orderDetail = orderDetailService.getOrderDetail(orderDetailId);
            
            if (orderDetail != null) {
                return new ResponseEntity<>(orderDetail, HttpStatus.OK);
            } else {
                throw new NotFoundEndPoint("OrderDetail with ID " + orderDetailId + " not found");
            }
        } catch (NumberFormatException e) {
            throw new DifferentDataTypeException("Invalid ID format. Please provide numeric values for orderNumber and orderLineNumber.");
        }
    }
}
