package com.JuanGreenGarden.Gardening.persistence.entity;

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
import lombok.Data;

import com.JuanGreenGarden.Gardening.persistence.entity.DTO.ProductLineDTO;;

@Data
@Entity
@Table(name = "gama_producto")
public class ProductLine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "gama", length = 50)
    private String productLine;

    @Column(name = "descripcion_texto")
    private String textDescription;

    @Column(name = "descripcion_html")
    private String htmlDescription;

    @Column(name = "imagen", length = 256)
    private String image;

    // Relationships

    @JsonIgnore
    @OneToMany(mappedBy = "productLineField", fetch = FetchType.EAGER)
    private List<Product> productLines;

    // DTO
    public ProductLineDTO toDTO(){
        ProductLineDTO dto = new ProductLineDTO();

        dto.setProductLine(productLine);
        dto.setTextDescription(textDescription);
        dto.setHtmlDescription(htmlDescription);
        dto.setImage(image);

        return dto;
    }
}
