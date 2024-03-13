package com.JuanGreenGarden.Gardening.persistence.entity;

import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "oficina")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "codigo_oficina", length = 100)
    private String officeCode;

    @Column(name = "ciudad", length = 30, nullable = false)
    private String city;

    @Column(name = "pais", length = 50, nullable = false)
    private String country;

    @Column(name = "region", length = 50)
    private String region;

    @Column(name = "codigo_postal", length = 50, nullable = false)
    private String postalCode;

    @Column(name = "telefono", length = 20, nullable = false)
    private String phone;

    @Column(name = "linea_direccion1", length = 50, nullable = false)
    private String addressLine1;

    @Column(name = "linea_direccion2", length = 50)
    private String addressLine2;

    // Relationships

    @JsonIgnore
    @OneToMany(mappedBy = "officeField", fetch = FetchType.EAGER)
    private List<Employee> offices;
}
