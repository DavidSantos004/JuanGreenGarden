package com.JuanGreenGarden.Gardening.persistence.entity;

import java.util.Date;

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
@Table(name = "pago")
public class Payment {
    @EmbeddedId
    private Payment id;

    @MapsId("customerNumber")
    @ManyToOne
    @JoinColumn(name = "codigo_cliente", referencedColumnName = "codigo_cliente")
    private Customer customer;

    @Column(name = "forma_pago", nullable = false)
    private String paymentMethod;

    @Column(name = "id_transaccion", nullable = false)
    private String transactionId;

    @Column(name = "fecha_pago", nullable = false)
    private Date paymentDate;

    @Column(name = "total", nullable = false)
    private double amount;
}
