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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.JuanGreenGarden.Gardening.persistence.entity.DTO.*;;

@Data
@Entity
@Table(name = "empleado")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_empleado")
    private Integer employeeNumber;

    @Column(name = "nombre", length = 50, nullable = false)
    private String firstName;

    @Column(name = "apellido1", length = 50, nullable = false)
    private String lastName1;

    @Column(name = "apellido2", length = 50)
    private String lastName2;

    @Column(name = "extension", length = 50, nullable = false)
    private String extension;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "puesto", length = 50)
    private String jobTitle;
    
    // Relationships
    
    @JsonIgnore
    @OneToMany(mappedBy = "employeeField", fetch = FetchType.EAGER)
    private List<Customer> employees;

    @JsonIgnore
    @OneToMany(mappedBy = "employeeField2", fetch = FetchType.EAGER)
    private List<Employee> employees2;

    @ManyToOne
    @JoinColumn(name = "codigo_oficina", nullable = false)
    private Office officeField;

    @ManyToOne
    @JoinColumn(name = "codigo_jefe")
    private Employee employeeField2;

    //DTO
    public EmployeeDTO toDTO(){
        EmployeeDTO dto = new EmployeeDTO();
        
        dto.setEmployeeNumber(employeeNumber);
        dto.setFirstName(firstName);
        dto.setLastName1(lastName1);
        dto.setLastName2(lastName2);
        dto.setExtension(extension);
        dto.setEmail(email);
        dto.setJobTitle(jobTitle);
        
        return dto;
    }
}
