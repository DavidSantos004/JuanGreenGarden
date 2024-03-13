package com.JuanGreenGarden.Gardening.persistence.entity;

import java.math.BigDecimal;
import java.util.List;

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
import lombok.Data;


@Data
@Entity
@Table(name = "producto")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "codigo_producto", length = 150)
    private String productCode;

    @Column(name = "nombre", length = 70, nullable = false)
    private String productName;

    @Column(name = "dimensiones", length = 100)
    private String productScale;

    @Column(name = "proveedor", length = 50)
    private String productVendor;

    @Column(name = "descripcion")
    private String productDescription;

    @Column(name = "cantidad_en_stock", length = 60, nullable = false)
    private Integer quantityInStock;

    @Column(name = "precio_venta",  nullable = false)
    private BigDecimal buyPrice;

    @Column(name = "precio_proveedor")
    private BigDecimal MSRP;

    // Relationships

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "gama", nullable = false)
    private ProductLine productLineField;

    @JsonIgnore
    @OneToMany(mappedBy = "productField", fetch = FetchType.EAGER)
    private List<OrderDetail> products;

}
