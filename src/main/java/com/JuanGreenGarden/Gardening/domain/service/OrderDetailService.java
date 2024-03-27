package com.JuanGreenGarden.Gardening.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.OrderDetailRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetail;
import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetailId;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.OrderDetailDTO;

/**
 * Servicio para la entidad OrderDetail.
 */
@Service
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    /**
     * Obtiene todos los detalles de órdenes.
     * 
     * @return Una lista de todos los detalles de órdenes.
     */
    public List<OrderDetailDTO> getAllOrdersDetail() {
        return orderDetailRepository.findAll().stream()
                .map(OrderDetail::toDTO)
                .toList();
    }

    /**
     * Obtiene un detalle de orden por su identificador.
     * 
     * @param orderDetailId El identificador del detalle de orden.
     * @return El detalle de orden correspondiente al identificador especificado.
     */
    public OrderDetail getOrderDetail(OrderDetailId orderDetailId) {
        return orderDetailRepository.findById(orderDetailId).orElse(null);
    }
}
