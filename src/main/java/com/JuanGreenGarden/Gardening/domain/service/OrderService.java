package com.JuanGreenGarden.Gardening.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.OrderRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.Order;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.OrderDTO;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(Order::toDTO)
                .toList();
    }

    public Order getOrderById(Integer orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    
}
