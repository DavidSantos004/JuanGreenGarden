package com.JuanGreenGarden.Gardening.persistence.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

import com.JuanGreenGarden.Gardening.persistence.entity.DTO.CustomerDTO;
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

@Data
@Entity
@Table(name = "cliente")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cliente", length = 50)
    private Integer customerNumber;

    @Column(name = "nombre_cliente", length = 50, nullable = false)
    private String customerName;

    @Column(name = "nombre_contacto", length = 30)
    private String contactFirstName;

    @Column(name = "apellido_contacto", length = 30)
    private String contactLastName;

    @Column(name = "telefono", length = 15,nullable = false)
    private String phone;

    @Column(name = "fax", length = 15, nullable = false)
    private String fax;

    @Column(name = "linea_direccion1", length = 50, nullable = false)
    private String addressLine1;

    @Column(name = "linea_direccion2", length = 50)
    private String addressLine2;

    @Column(name = "ciudad", length = 50, nullable = false)
    private String city;

    @Column(name = "region", length = 50)
    private String region;

    @Column(name = "pais", length = 50)
    private String country;

    @Column(name = "codigo_postal", length = 50)
    private String postalCode;

    @Column(name = "limite_credito", columnDefinition = "numeric")
    private BigDecimal creditLimit;

    // Relationships

    @JsonIgnore
    @OneToMany(mappedBy = "customerField", fetch = FetchType.EAGER)
    private List<Order> customers;

    @JsonIgnore
    @OneToMany(mappedBy = "customerField2", fetch = FetchType.EAGER)
    private List<Payment> customers2;

    
    @ManyToOne
    @JoinColumn(name = "codigo_empleado_rep_ventas")
    private Employee employeeField;

    // DTO
    public CustomerDTO toDTO(){
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerNumber(customerNumber);
        dto.setCustomerName(customerName);
        dto.setContactFirstName(contactFirstName);
        dto.setContactLastName(contactLastName);
        dto.setPhone(phone);
        dto.setFax(fax);
        dto.setAddressLine1(addressLine1);
        dto.setAddressLine2(addressLine2);
        dto.setCity(city);
        dto.setRegion(region);
        dto.setCountry(country);
        dto.setPostalCode(postalCode);
        dto.setCreditLimit(creditLimit);
        return dto;
    }  
}

