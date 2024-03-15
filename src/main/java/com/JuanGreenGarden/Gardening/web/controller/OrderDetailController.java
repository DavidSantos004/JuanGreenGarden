package com.JuanGreenGarden.Gardening.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JuanGreenGarden.Gardening.domain.Exceptions.DifferentDataTypeException;
import com.JuanGreenGarden.Gardening.domain.Exceptions.NotFoundEndPoint;
import com.JuanGreenGarden.Gardening.domain.service.OrderDetailService;
import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetail;
import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetailId;
@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @Autowired
    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDetail>> getAllOrderDetails() {
        List<OrderDetail> orderDetails = orderDetailService.getAllOrderDetails();
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    @GetMapping("/{orderNumber}/{orderLineNumber}")
    public ResponseEntity<OrderDetail> getOrderDetail(@PathVariable String orderNumber, @PathVariable String orderLineNumber) {
        try {
            Integer number = Integer.parseInt(orderNumber);
            Integer lineNumber = Integer.parseInt(orderLineNumber);

            // Si ambos números son enteros válidos, procedemos a buscar el detalle de la orden
            OrderDetailId orderDetailId = new OrderDetailId(number, lineNumber);
            OrderDetail orderDetail = orderDetailService.getOrderDetail(orderDetailId);
            
            if (orderDetail != null) {
                return new ResponseEntity<>(orderDetail, HttpStatus.OK);
            } else {
                throw new NotFoundEndPoint("OrderDetail with ID " + orderDetailId + " not found");
            }
        } catch (NumberFormatException e) {
            // Si alguno de los valores no es un número válido, lanzamos una excepción de tipo BadRequest
            throw new DifferentDataTypeException("Invalid ID format. Please provide numeric values for orderNumber and orderLineNumber.");
        }
}

}