package com.JuanGreenGarden.Gardening.persistence.entity;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "oficina")
public class Office {
    @Id
    @Column(name = "codigo_oficina")
    private String officeCode;

    @Column(name = "ciudad", nullable = false)
    private String city;

    @Column(name = "pais", nullable = false)
    private String country;

    @Column(name = "region")
    private String region;

    @Column(name = "codigo_postal", nullable = false)
    private String postalCode;

    @Column(name = "telefono", nullable = false)
    private String phone;

    @Column(name = "linea_direccion1", nullable = false)
    private String addressLine1;

    @Column(name = "linea_direccion2")
    private String addressLine2;
}
