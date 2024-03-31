package com.JuanGreenGarden.Gardening.persistence.entity;


import java.math.BigDecimal;

public class BillingSummary {
    private BigDecimal baseImponible;
    private BigDecimal iva;
    private BigDecimal totalFacturado;


    public BillingSummary(BigDecimal baseImponible, BigDecimal iva, BigDecimal totalFacturado) {
        this.baseImponible = baseImponible;
        this.iva = iva;
        this.totalFacturado = totalFacturado;
    }

    // Getters y setters

    
    public BigDecimal getBaseImponible() {
        return baseImponible;
    }

    public void setBaseImponible(BigDecimal baseImponible) {
        this.baseImponible = baseImponible;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getTotalFacturado() {
        return totalFacturado;
    }

    public void setTotalFacturado(BigDecimal totalFacturado) {
        this.totalFacturado = totalFacturado;
    }

    
}