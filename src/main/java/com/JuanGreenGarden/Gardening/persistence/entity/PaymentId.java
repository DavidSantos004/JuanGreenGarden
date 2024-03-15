package com.JuanGreenGarden.Gardening.persistence.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PaymentId implements Serializable {
    @Column(name = "codigo_cliente")
    private Integer customerNumber;

    @Column(name = "id_transaccion")
    private String transactionId;
}
