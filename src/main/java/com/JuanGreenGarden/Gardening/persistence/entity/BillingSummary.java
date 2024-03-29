package com.JuanGreenGarden.Gardening.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BillingSummary {
    private BigDecimal baseImponible;
    private BigDecimal iva;
    private BigDecimal totalFacturado;
}

