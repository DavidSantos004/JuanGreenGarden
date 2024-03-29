package com.JuanGreenGarden.Gardening.persistence.entity;

import lombok.Data;

@Data
public class CustomerRepresentativeOfficeDTO {
    private String customerName;
    private String representativeFirstName;
    private String representativeLastName;
    private String representativeOfficeCity;
}