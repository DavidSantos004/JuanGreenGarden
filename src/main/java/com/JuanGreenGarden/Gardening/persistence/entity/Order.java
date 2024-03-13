package com.JuanGreenGarden.Gardening.persistence.entity;

import lombok.Data;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "pedido")
public class Order {
    @Id
    @Column(name = "codigo_pedido")
    private Integer orderNumber;

    @Column(name = "fecha_pedido", nullable = false)
    private Date orderDate;

    @Column(name = "fecha_esperada", nullable = false)
    private Date requiredDate;

    @Column(name = "fecha_entrega")
    private Date shippedDate;

    @Column(name = "estado", nullable = false)
    private String status;

    @Column(name = "comentarios")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "codigo_cliente", nullable = false)
    private Customer customer;
}
