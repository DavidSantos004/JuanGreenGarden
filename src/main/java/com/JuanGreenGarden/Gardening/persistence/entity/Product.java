package com.JuanGreenGarden.Gardening.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "producto")
public class Product {
    @Id
    @Column(name = "codigo_producto")
    private String productCode;

    @Column(name = "nombre", nullable = false)
    private String productName;

    @ManyToOne
    @JoinColumn(name = "gama", nullable = false)
    private ProductLine productLine;

    @Column(name = "dimensiones")
    private String productScale;

    @Column(name = "proveedor")
    private String productVendor;

    @Column(name = "descripcion")
    private String productDescription;

    @Column(name = "cantidad_en_stock", nullable = false)
    private Integer quantityInStock;

    @Column(name = "precio_venta", nullable = false)
    private double buyPrice;

    @Column(name = "precio_proveedor")
    private double MSRP;
}
