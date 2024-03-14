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
    public ResponseEntity<OrderDetail> getOrderDetail(@PathVariable Integer orderNumber, @PathVariable Integer orderLineNumber) {
        OrderDetailId orderDetailId = new OrderDetailId(orderNumber, orderLineNumber);
        OrderDetail orderDetail = orderDetailService.getOrderDetail(orderDetailId);
        return orderDetail != null ?
                new ResponseEntity<>(orderDetail, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail) {
        OrderDetail createdOrderDetail = orderDetailService.createOrUpdateOrderDetail(orderDetail);
        return new ResponseEntity<>(createdOrderDetail, HttpStatus.CREATED);
    }

    @PutMapping("/{orderNumber}/{orderLineNumber}")
    public ResponseEntity<OrderDetail> updateOrderDetail(@PathVariable Integer orderNumber, @PathVariable Integer orderLineNumber, @RequestBody OrderDetail orderDetail) {
        OrderDetailId orderDetailId = new OrderDetailId(orderNumber, orderLineNumber);
        orderDetail.setOrderDetailId(orderDetailId);
        OrderDetail updatedOrderDetail = orderDetailService.createOrUpdateOrderDetail(orderDetail);
        return new ResponseEntity<>(updatedOrderDetail, HttpStatus.OK);
    }

    @DeleteMapping("/{orderNumber}/{orderLineNumber}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable Integer orderNumber, @PathVariable Integer orderLineNumber) {
        OrderDetailId orderDetailId = new OrderDetailId(orderNumber, orderLineNumber);
        orderDetailService.deleteOrderDetail(orderDetailId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}