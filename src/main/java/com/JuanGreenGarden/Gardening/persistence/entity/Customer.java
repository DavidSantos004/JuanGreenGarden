package com.JuanGreenGarden.Gardening.persistence.entity;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "cliente")
public class Customer {
    @Id
    @Column(name = "codigo_cliente")
    private Integer customerNumber;

    @Column(name = "nombre_cliente", nullable = false)
    private String customerName;

    @Column(name = "nombre_contacto")
    private String contactFirstName;

    @Column(name = "apellido_contacto")
    private String contactLastName;

    @Column(name = "telefono", nullable = false)
    private String phone;

    @Column(name = "fax", nullable = false)
    private String fax;

    @Column(name = "linea_direccion1", nullable = false)
    private String addressLine1;

    @Column(name = "linea_direccion2")
    private String addressLine2;

    @Column(name = "ciudad", nullable = false)
    private String city;

    @Column(name = "region")
    private String region;

    @Column(name = "pais")
    private String country;

    @Column(name = "codigo_postal")
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "codigo_empleado_rep_ventas")
    private Employee salesRepEmployee;

    @Column(name = "limite_credito")
    private Double creditLimit;
}

