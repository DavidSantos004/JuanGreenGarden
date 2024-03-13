package com.JuanGreenGarden.Gardening.persistence.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "pago")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
        name = "customer_number_sequence",
        sequenceName = "customer_number_sequence",
        allocationSize = 1
    )
    @Column(name = "codigo_cliente")
    private Integer customerNumber;

    @Column(name = "id_transaccion", length = 50, nullable = false)
    private String transactionId;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_pago", nullable = false)
    private Date paymentDate;

    @Column(name = "total", nullable = false)
    private BigDecimal amount;

    @Column(name = "forma_pago", length = 40,  nullable = false)
    private String paymentMethod;

    // Relationships

    @ManyToOne
    @JoinColumn(name = "codigo_cliente", referencedColumnName = "codigo_cliente", insertable = false, updatable = false)
    private Customer customerField2;
}
