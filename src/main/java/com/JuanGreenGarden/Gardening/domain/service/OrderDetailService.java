package com.JuanGreenGarden.Gardening.domain.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.JuanGreenGarden.Gardening.domain.repository.OfficeRepository;
import com.JuanGreenGarden.Gardening.domain.repository.OrderDetailRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetail;
import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetailId;

@Service
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    public OrderDetail getOrderDetail(OrderDetailId orderDetailId) {
        return orderDetailRepository.findById(orderDetailId).orElse(null);
    }

    public OrderDetail createOrUpdateOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    public void deleteOrderDetail(OrderDetailId orderDetailId) {
        orderDetailRepository.deleteById(orderDetailId);
    }
}