package com.JuanGreenGarden.Gardening.web.controller;

import java.math.BigDecimal;
import java.util.List;

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
import com.JuanGreenGarden.Gardening.domain.service.PaymentService;
import com.JuanGreenGarden.Gardening.persistence.entity.Payment;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.PaymentDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/**
 * Controlador REST para operaciones relacionadas con los pagos.
 */
@RestController
@RequestMapping("/api/payments")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Obtiene todos los pagos.
     * 
     * @return Una respuesta con una lista de todos los pagos.
     */
    @GetMapping
    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
        List<PaymentDTO> payments = paymentService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    /**
     * Obtiene un pago por su ID.
     * 
     * @param paymentId El ID del pago.
     * @return Una respuesta con el pago correspondiente al ID especificado.
     * @throws NotFoundEndPoint Si no se encuentra ningún pago con el ID especificado.
     * @throws DifferentDataTypeException Si el formato del ID del pago es inválido.
     */
    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable String paymentId) {
        try {
            Integer id = Integer.parseInt(paymentId);
            Payment payment = paymentService.getPaymentById(id);
            
            if (payment != null) {
                return new ResponseEntity<>(payment, HttpStatus.OK);
            } else {
                throw new NotFoundEndPoint("Payment with ID " + id + " not found");
            }
        } catch (NumberFormatException e) {
            throw new DifferentDataTypeException("Invalid ID format. Please provide a numeric value for paymentId.");
        }
    }

    /**
     * Obtiene los números de cliente únicos en el año 2008.
     * 
     * @return Una respuesta con una lista de números de cliente únicos en el año 2008.
     */
    @GetMapping("/unique-customers-2008")
    public ResponseEntity<List<Integer>> getUniqueCustomersInDate2008() {
        List<Integer> uniqueCustomers = paymentService.getUniqueCustomerNumbersInDate2008();
        return new ResponseEntity<>(uniqueCustomers, HttpStatus.OK);
    }
    
    /**
     * Obtiene todos los pagos realizados en el año 2008 utilizando el método de pago "PayPal".
     * 
     * @return Lista de pagos que cumplen con los criterios especificados.
     */
    @GetMapping("/payments-2008")
    public List<Payment> getAllPaymentsForYearAndMethod() {
        int year = 2008;
        String method = "PayPal";
        return paymentService.getAllPaymentsForYearAndMethod(year, method);
    }

    /**
     * Obtiene todos los métodos de pago distintos.
     * 
     * @return Lista de métodos de pago distintos.
     */
    @GetMapping("/payment-methods")
    public List<String> findAllPaymentMethods() {
        return paymentService.findAllPaymentMethods();
    }

    /**
     * Obtiene el pago medio para el año fijo 2009.
     * 
     * @return ResponseEntity con el pago medio para el año 2009.
     */
    @GetMapping("/average-2009")
    public ResponseEntity<String> getAveragePaymentForFixedYear() {
        int fixedYear = 2009; 
        BigDecimal average = paymentService.calculateAveragePaymentForYear(fixedYear);
        return ResponseEntity.ok("The average payment in the year " + fixedYear + " it was of: " + average.toString());
    }

    /**
     * Endpoint para obtener la fecha del primer y último pago realizado por cada cliente.
     *
     * @return Lista de arrays de objetos que contienen el nombre y apellidos del cliente, así como la fecha del primer y último pago.
     */
    @GetMapping("/first-and-last-payment-dates-for-customers")
    public ResponseEntity<List<Object[]>> findFirstAndLastPaymentDatesForCustomers() {
        List<Object[]> paymentDates = paymentService.findFirstAndLastPaymentDatesForCustomers();
        return new ResponseEntity<>(paymentDates, HttpStatus.OK);
    }

    /**
     * Obtiene la suma total de los pagos agrupados por año.
     * @return ResponseEntity con la lista de arreglos de objetos, donde cada arreglo contiene el año y la suma total de pagos para ese año.
     */
    @GetMapping("/total-by-year")
    public ResponseEntity<List<Object[]>> getTotalPaymentsByYear() {
        List<Object[]> totalPaymentsByYear = paymentService.findTotalPaymentsByYear();
        return ResponseEntity.ok(totalPaymentsByYear);
    }
    

    /**
     * Obtiene el nombre de los clientes que han hecho pagos y el nombre de sus representantes
     * junto con la ciudad de la oficina a la que pertenece el representante.
     * @return Respuesta HTTP con la lista de objetos que contienen el nombre del cliente, nombre del representante,
     * apellido del representante y ciudad de la oficina.
     */
    @GetMapping("/customer-representative-city")
    public ResponseEntity<List<Object[]>> getCustomerPaymentsAndRepresentatives() {
        List<Object[]> result = paymentService.findCustomerPaymentsAndRepresentatives();
        return ResponseEntity.ok(result);
    }
}
