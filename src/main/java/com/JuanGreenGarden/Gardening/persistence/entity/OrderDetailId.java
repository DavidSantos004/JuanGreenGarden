package com.JuanGreenGarden.Gardening.persistence.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
@Embeddable
public class OrderDetailId implements Serializable {
    @Column(name = "codigo_pedido", length = 100)
    private Integer orderNumber;

    @Column(name = "numero_linea", length = 60)
    private Integer orderLineNumber;
}
