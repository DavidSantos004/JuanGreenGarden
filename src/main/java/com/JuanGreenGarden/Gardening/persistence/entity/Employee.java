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
@Table(name = "empleado")
public class Employee {
    @Id
    @Column(name = "codigo_empleado")
    private Integer employeeNumber;

    @Column(name = "nombre", nullable = false)
    private String firstName;

    @Column(name = "apellido1", nullable = false)
    private String lastName1;

    @Column(name = "apellido2")
    private String lastName2;

    @Column(name = "extension", nullable = false)
    private String extension;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "codigo_oficina", nullable = false)
    private Office office;

    @ManyToOne
    @JoinColumn(name = "codigo_jefe")
    private Employee manager;

    @Column(name = "puesto")
    private String jobTitle;
}
