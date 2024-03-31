package com.JuanGreenGarden.Gardening.web.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JuanGreenGarden.Gardening.domain.Exceptions.DifferentDataTypeException;
import com.JuanGreenGarden.Gardening.domain.Exceptions.NotFoundEndPoint;
import com.JuanGreenGarden.Gardening.domain.service.OrderDetailService;
import com.JuanGreenGarden.Gardening.persistence.entity.BillingSummary;
import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetail;
import com.JuanGreenGarden.Gardening.persistence.entity.OrderDetailId;
import com.JuanGreenGarden.Gardening.persistence.entity.ProductBillingSummary;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.OrderDetailDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/**
 * Controlador REST para operaciones relacionadas con los detalles de órdenes.
 */
@RestController
@RequestMapping("/api/orderdetails")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @Autowired
    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    /**
     * Obtiene todos los detalles de órdenes.
     * 
     * @return Una respuesta con una lista de todos los detalles de órdenes.
     */
    @GetMapping
    public ResponseEntity<List<OrderDetailDTO>> getAllOrderDetails() {
        List<OrderDetailDTO> orderDetails = orderDetailService.getAllOrdersDetail();
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    /**
     * Obtiene un detalle de orden por su número de orden y número de línea.
     * 
     * @param orderNumber    El número de orden.
     * @param orderLineNumber    El número de línea de la orden.
     * @return Una respuesta con el detalle de orden correspondiente.
     * @throws NotFoundEndPoint Si no se encuentra ningún detalle de orden con los números especificados.
     * @throws DifferentDataTypeException Si los números de orden no son valores numéricos válidos.
     */
    @GetMapping("/{orderNumber}/{orderLineNumber}")
    public ResponseEntity<OrderDetail> getOrderDetail(@PathVariable String orderNumber, @PathVariable String orderLineNumber) {
        try {
            Integer number = Integer.parseInt(orderNumber);
            Integer lineNumber = Integer.parseInt(orderLineNumber);

            OrderDetailId orderDetailId = new OrderDetailId(number, lineNumber);
            OrderDetail orderDetail = orderDetailService.getOrderDetail(orderDetailId);
            
            if (orderDetail != null) {
                return new ResponseEntity<>(orderDetail, HttpStatus.OK);
            } else {
                throw new NotFoundEndPoint("OrderDetail with ID " + orderDetailId + " not found");
            }
        } catch (NumberFormatException e) {
            throw new DifferentDataTypeException("Invalid ID format. Please provide numeric values for orderNumber and orderLineNumber.");
        }
    }

    /**
     * Endpoint para obtener el número de productos diferentes en cada pedido.
     *
     * @return Lista de arrays de objetos que contienen el número de pedido y el número de productos diferentes.
     */
    @GetMapping("/count-distinct-products-in-orders")
    public ResponseEntity<List<Object[]>> countDistinctProductsInOrders() {
        List<Object[]> productsInOrders = orderDetailService.countDistinctProductsInOrders();
        return new ResponseEntity<>(productsInOrders, HttpStatus.OK);
    }

    /**
     * Endpoint para obtener la suma de la cantidad total de todos los productos en cada pedido.
     *
     * @return Lista de arrays de objetos que contienen el número de pedido y la suma de la cantidad total de productos.
     */
    @GetMapping("/sum-total-quantity-in-orders")
    public ResponseEntity<List<Object[]>> sumTotalQuantityInOrders() {
        List<Object[]> totalQuantityInOrders = orderDetailService.sumTotalQuantityInOrders();
        return new ResponseEntity<>(totalQuantityInOrders, HttpStatus.OK);
    }

    /**
     * Obtiene un resumen de facturación que incluye la base imponible, el IVA y el total facturado.
     *
     * @return Un ResponseEntity con el resumen de facturación.
     */
    @GetMapping("/billing-summary")
    public ResponseEntity<BillingSummary> getBillingSummary() {
        BigDecimal baseImponible = orderDetailService.calcularBaseImponible();
        BigDecimal iva = orderDetailService.calcularIVA(baseImponible);
        BigDecimal totalFacturado = orderDetailService.calcularTotalFacturado(baseImponible, iva);

        BillingSummary summary = new BillingSummary(baseImponible, iva, totalFacturado);
        return ResponseEntity.ok(summary);
    }

    /**
     * Obtiene un resumen de facturación por producto, incluyendo la base imponible, el IVA y el total facturado.
     * @return ResponseEntity con un mapa que contiene el resumen de facturación por producto.
     */
    @GetMapping("/summary-by-product")
    public ResponseEntity<Map<String, ProductBillingSummary>> getProductBillingSummary() {
        Map<String, BigDecimal> baseImponiblePorProducto = orderDetailService.calcularBaseImponiblePorProducto();
        Map<String, BigDecimal> ivaPorProducto = orderDetailService.calcularIVAPorProducto(baseImponiblePorProducto);
        Map<String, BigDecimal> totalFacturadoPorProducto = orderDetailService.calcularTotalFacturadoPorProducto(baseImponiblePorProducto, ivaPorProducto);

        Map<String, ProductBillingSummary> productBillingSummaryMap = ProductBillingSummary.fromMaps(baseImponiblePorProducto, ivaPorProducto, totalFacturadoPorProducto);
        return ResponseEntity.ok(productBillingSummaryMap);
    }

    /**
     * Obtiene un resumen de facturación filtrado por producto, incluyendo la base imponible, el IVA y el total facturado.
     * @return ResponseEntity con un objeto BillingSummary que contiene el resumen de facturación filtrado por producto.
     */
    @GetMapping("/summary-by-product-filtered")
    public ResponseEntity<BillingSummary> getBillingSummaryByProductFiltered() {
        BigDecimal baseImponible = orderDetailService.calcularBaseImponiblePorProductoFiltrado();
        BigDecimal iva = orderDetailService.calcularIVAPorProductoFiltrado();
        BigDecimal totalFacturado = orderDetailService.calcularTotalFacturadoPorProductoFiltrado();

        BillingSummary summary = new BillingSummary(baseImponible, iva, totalFacturado);
        return ResponseEntity.ok(summary);
    }

    /**
     * Obtiene los detalles del pedido cuyo total es mayor que 3000 euros.
     * @return ResponseEntity con una lista de detalles del pedido cuyo total es mayor que 3000 euros.
     */
    @GetMapping("/total-sales-over-3000")
    public ResponseEntity<List<OrderDetail>> getTotalSalesOver3000() {
        List<OrderDetail> orderDetails = orderDetailService.findOrderDetailsWithTotalGreaterThan3000();
        return ResponseEntity.ok(orderDetails);
    }
}

