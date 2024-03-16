package com.JuanGreenGarden.Gardening.persistence.entity;


import com.JuanGreenGarden.Gardening.persistence.entity.DTO.OrderDetailDTO;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "detalle_pedido")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailId orderDetailId;

    @Column(name = "cantidad", length = 100,nullable = false)
    private Integer quantityOrdered;

    @Column(name = "precio_unidad", nullable = false)
    private double priceEach;

    // Relationships

    @MapsId("orderNumber")
    @ManyToOne
    @JoinColumn(name = "codigo_pedido", referencedColumnName = "codigo_pedido")
    private Order orderField;

    @ManyToOne
    @JoinColumn(name = "codigo_producto", referencedColumnName = "codigo_producto")
    private Product productField;

    public OrderDetailDTO toDTO(){
        OrderDetailDTO dto = new OrderDetailDTO();

        dto.setOrderDetailId(orderDetailId);
        dto.setQuantityOrdered(quantityOrdered);
        dto.setPriceEach(priceEach);

        return dto;
    }

}
