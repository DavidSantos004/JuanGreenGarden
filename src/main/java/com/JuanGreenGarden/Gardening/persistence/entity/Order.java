package com.JuanGreenGarden.Gardening.persistence.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

import com.JuanGreenGarden.Gardening.persistence.entity.DTO.OrderDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Data
@Entity
@Table(name = "pedido")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_pedido", length = 100)
    private Integer orderNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_pedido", nullable = false)
    private Date orderDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_esperada", nullable = false)
    private Date requiredDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_entrega")
    private Date shippedDate;

    @Column(name = "estado", length = 15, nullable = false)
    private String status;

    @Column(name = "comentarios")
    private String comments;

    // Relationships

    @JsonIgnore
    @OneToMany(mappedBy = "orderField", fetch = FetchType.EAGER)
    private List<OrderDetail> orders;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "codigo_cliente", nullable = false)
    private Customer customerField;

    //DTO
    public OrderDTO toDTO(){
        OrderDTO dto = new OrderDTO();

        dto.setOrderNumber(orderNumber);
        dto.setOrderDate(orderDate);
        dto.setRequiredDate(requiredDate);
        dto.setShippedDate(shippedDate);
        dto.setStatus(status);
        dto.setComments(comments);

        return dto;
    }
}
