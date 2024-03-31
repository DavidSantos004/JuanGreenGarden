package com.JuanGreenGarden.Gardening.domain.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.OrderDetailRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.BillingSummary;
import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetail;
import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetailId;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.OrderDetailDTO;

/**
 * Servicio para la entidad OrderDetail.
 */
@Service
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    /**
     * Obtiene todos los detalles de órdenes.
     * 
     * @return Una lista de todos los detalles de órdenes.
     */
    public List<OrderDetailDTO> getAllOrdersDetail() {
        return orderDetailRepository.findAll().stream()
                .map(OrderDetail::toDTO)
                .toList();
    }

    /**
     * Obtiene un detalle de orden por su identificador.
     * 
     * @param orderDetailId El identificador del detalle de orden.
     * @return El detalle de orden correspondiente al identificador especificado.
     */
    public OrderDetail getOrderDetail(OrderDetailId orderDetailId) {
        return orderDetailRepository.findById(orderDetailId).orElse(null);
    }

    /**
     * Calcula el número de productos diferentes en cada pedido.
     *
     * @return Lista de arrays de objetos que contienen el número de pedido y el número de productos diferentes.
     */
    public List<Object[]> countDistinctProductsInOrders() {
        return orderDetailRepository.countDistinctProductsInOrders();
    }

    /**
     * Calcula la suma de la cantidad total de todos los productos en cada pedido.
     *
     * @return Lista de arrays de objetos que contienen el número de pedido y la suma de la cantidad total de productos.
     */
    public List<Object[]> sumTotalQuantityInOrders() {
        return orderDetailRepository.sumTotalQuantityInOrders();
    }

    /**
     * Calcula la base imponible sumando el costo de todos los productos vendidos en los detalles de los pedidos.
     *
     * @return La base imponible calculada.
     */
    public BigDecimal calcularBaseImponible() {
        List<OrderDetail> detallesPedido = orderDetailRepository.findAll();
        BigDecimal baseImponible = BigDecimal.ZERO;

        for (OrderDetail detalle : detallesPedido) {
            BigDecimal precioTotal = BigDecimal.valueOf(detalle.getQuantityOrdered()).multiply(BigDecimal.valueOf(detalle.getPriceEach()));
            baseImponible = baseImponible.add(precioTotal);
        }

        return baseImponible;
    }

    /**
     * Calcula el valor del Impuesto al Valor Agregado (IVA) sobre una base imponible dada.
     *
     * @param baseImponible La base imponible sobre la cual calcular el IVA.
     * @return El monto del IVA calculado.
     */
    public BigDecimal calcularIVA(BigDecimal baseImponible) {
        return baseImponible.multiply(BigDecimal.valueOf(0.21)); // IVA es el 21%
    }

    /**
     * Calcula el total facturado sumando la base imponible y el IVA.
     *
     * @param baseImponible La base imponible de la facturación.
     * @param iva           El monto del IVA.
     * @return El total facturado.
     */
    public BigDecimal calcularTotalFacturado(BigDecimal baseImponible, BigDecimal iva) {
        return baseImponible.add(iva);
    }

    /**
     * Calcula la base imponible agrupada por código de producto.
     *
     * @return Un mapa que contiene el código del producto como clave y la base imponible como valor.
     */
    public Map<String, BigDecimal> calcularBaseImponiblePorProducto() {
        List<OrderDetail> detallesPedido = orderDetailRepository.findAll();
        Map<String, BigDecimal> baseImponiblePorProducto = new HashMap<>();

        for (OrderDetail detalle : detallesPedido) {
            BigDecimal precioTotal = BigDecimal.valueOf(detalle.getQuantityOrdered()).multiply(BigDecimal.valueOf(detalle.getPriceEach()));
            String codigoProducto = detalle.getProductField().getProductCode();
            baseImponiblePorProducto.put(codigoProducto, baseImponiblePorProducto.getOrDefault(codigoProducto, BigDecimal.ZERO).add(precioTotal));
        }

        return baseImponiblePorProducto;
    }

    /**
     * Calcula el IVA para cada código de producto en base a la base imponible por producto.
     *
     * @param baseImponiblePorProducto Mapa que contiene el código del producto como clave y la base imponible como valor.
     * @return Un mapa que contiene el código del producto como clave y el monto del IVA como valor.
     */
    public Map<String, BigDecimal> calcularIVAPorProducto(Map<String, BigDecimal> baseImponiblePorProducto) {
        Map<String, BigDecimal> ivaPorProducto = new HashMap<>();

        for (Map.Entry<String, BigDecimal> entry : baseImponiblePorProducto.entrySet()) {
            String codigoProducto = entry.getKey();
            BigDecimal baseImponible = entry.getValue();
            BigDecimal iva = baseImponible.multiply(BigDecimal.valueOf(0.21)); // IVA es el 21%
            ivaPorProducto.put(codigoProducto, iva);
        }

        return ivaPorProducto;
    }

    /**
     * Calcula el total facturado para cada código de producto en base a la base imponible y el IVA por producto.
     *
     * @param baseImponiblePorProducto Mapa que contiene el código del producto como clave y la base imponible como valor.
     * @param ivaPorProducto           Mapa que contiene el código del producto como clave y el monto del IVA como valor.
     * @return Un mapa que contiene el código del producto como clave y el total facturado como valor.
     */
    public Map<String, BigDecimal> calcularTotalFacturadoPorProducto(Map<String, BigDecimal> baseImponiblePorProducto, Map<String, BigDecimal> ivaPorProducto) {
        Map<String, BigDecimal> totalFacturadoPorProducto = new HashMap<>();

        for (Map.Entry<String, BigDecimal> entry : baseImponiblePorProducto.entrySet()) {
            String codigoProducto = entry.getKey();
            BigDecimal baseImponible = entry.getValue();
            BigDecimal iva = ivaPorProducto.get(codigoProducto);
            BigDecimal totalFacturado = baseImponible.add(iva);
            totalFacturadoPorProducto.put(codigoProducto, totalFacturado);
        }

        return totalFacturadoPorProducto;
    }
    
   /**
     * Calcula la base imponible total para los productos cuyo código comienza con "OR".
     * @return La base imponible total de los productos filtrados.
     */
    public BigDecimal calcularBaseImponiblePorProductoFiltrado() {
        List<OrderDetail> detallesPedido = orderDetailRepository.findByProductField_ProductCodeStartingWith("OR");
        BigDecimal baseImponible = BigDecimal.ZERO;

        for (OrderDetail detalle : detallesPedido) {
            BigDecimal precioTotal = BigDecimal.valueOf(detalle.getQuantityOrdered()).multiply(BigDecimal.valueOf(detalle.getPriceEach()));
            baseImponible = baseImponible.add(precioTotal);
        }

        return baseImponible;
    }

    // Implementa otros métodos para calcular el IVA y el total facturado según sea necesario


    /**
     * Calcula el monto del IVA para los productos filtrados.
     * @return El monto del IVA para los productos filtrados.
     */
    public BigDecimal calcularIVAPorProductoFiltrado() {
        BigDecimal baseImponible = calcularBaseImponiblePorProductoFiltrado();
        return baseImponible.multiply(BigDecimal.valueOf(0.21)); // IVA es el 21%
    }

    /**
     * Calcula el total facturado para los productos filtrados, incluyendo el IVA.
     * @return El total facturado para los productos filtrados, incluyendo el IVA.
     */
    public BigDecimal calcularTotalFacturadoPorProductoFiltrado() {
        BigDecimal baseImponible = calcularBaseImponiblePorProductoFiltrado();
        BigDecimal iva = calcularIVAPorProductoFiltrado();
        return baseImponible.add(iva);
    }

    /**
     * Encuentra los detalles del pedido cuyo total es mayor que 3000 euros.
     * @return Lista de detalles del pedido cuyo total es mayor que 3000 euros.
     */
    public List<OrderDetail> findOrderDetailsWithTotalGreaterThan3000() {
        return orderDetailRepository.findOrderDetailsWithTotalGreaterThan3000();
    }
}
