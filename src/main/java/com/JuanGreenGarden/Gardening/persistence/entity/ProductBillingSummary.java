package com.JuanGreenGarden.Gardening.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class ProductBillingSummary {
    private String productCode;
    private BigDecimal baseImponible;
    private BigDecimal iva;
    private BigDecimal totalFacturado;

    public static Map<String, ProductBillingSummary> fromMaps(Map<String, BigDecimal> baseImponiblePorProducto, Map<String, BigDecimal> ivaPorProducto, Map<String, BigDecimal> totalFacturadoPorProducto) {
        Map<String, ProductBillingSummary> summaryMap = new HashMap<>();

        for (Map.Entry<String, BigDecimal> entry : baseImponiblePorProducto.entrySet()) {
            String productCode = entry.getKey();
            BigDecimal baseImponible = entry.getValue();
            BigDecimal iva = ivaPorProducto.get(productCode);
            BigDecimal totalFacturado = totalFacturadoPorProducto.get(productCode);
            summaryMap.put(productCode, new ProductBillingSummary(productCode, baseImponible, iva, totalFacturado));
        }

        return summaryMap;
    }
}

