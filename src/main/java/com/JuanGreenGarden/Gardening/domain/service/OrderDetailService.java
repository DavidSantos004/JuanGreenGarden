package com.JuanGreenGarden.Gardening.domain.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.OrderDetailRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetail;
import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetailId;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.OrderDetailDTO;

@Service
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public List<OrderDetailDTO> getAllOrdersDetail() {
        return orderDetailRepository.findAll().stream()
                .map(OrderDetail::toDTO)
                .toList();
    }

    public OrderDetail getOrderDetail(OrderDetailId orderDetailId) {
        return orderDetailRepository.findById(orderDetailId).orElse(null);
    }
}