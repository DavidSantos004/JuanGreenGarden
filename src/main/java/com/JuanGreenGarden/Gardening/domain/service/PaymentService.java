package com.JuanGreenGarden.Gardening.domain.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.PaymentRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.Payment;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.PaymentDTO;

/**
 * Servicio para la entidad Payment.
 */
@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    /**
     * Obtiene un pago por su ID.
     * 
     * @param paymentId ID del pago.
     * @return El pago correspondiente al ID especificado.
     */
    public Payment getPaymentById(Integer paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

    /**
     * Obtiene todos los pagos.
     * 
     * @return Lista de todos los pagos.
     */
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(Payment::toDTO)
                .toList();
    }   

    /**
     * Obtiene los números de cliente únicos en el año 2008.
     * 
     * @return Lista de números de cliente únicos en el año 2008.
     */
    public List<Integer> getUniqueCustomerNumbersInDate2008() {
        return paymentRepository.findDistinctCustomerNumbersIn2008();
    }
    
    /**
     * Obtiene todos los pagos para un año y método de pago específicos.
     * 
     * @param year Año de los pagos.
     * @param method Método de pago.
     * @return Lista de pagos que cumplen con los criterios especificados.
     */
    public List<Payment> getAllPaymentsForYearAndMethod(int year, String method) {
        return paymentRepository.findByYearAndMethod(year, method);
    }

    /**
     * Obtiene todos los métodos de pago distintos.
     * 
     * @return Lista de métodos de pago distintos.
     */
    public List<String> findAllPaymentMethods() {
        return paymentRepository.findAllPaymentMethods();
    }

    /**
     * Calcula el pago medio para un año específico.
     * 
     * @param year Año para el cual se calculará el pago medio.
     * @return     El pago medio para el año especificado.
     */
     public BigDecimal calculateAveragePaymentForYear(int year) {
        List<Payment> payments = findPaymentsInYear(year);
        return calculateAveragePayment(payments);
    }

    /**
     * Busca los pagos realizados durante un año específico.
     * 
     * @param year Año para el cual se buscarán los pagos.
     * @return     Lista de pagos realizados durante el año especificado.
     */
    private List<Payment> findPaymentsInYear(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, Calendar.JANUARY, 1, 0, 0, 0);
        Date startDate = calendar.getTime();
        calendar.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
        Date endDate = calendar.getTime();
        return paymentRepository.findByPaymentDateBetween(startDate, endDate);
    }

    /**
     * Calcula el pago medio a partir de una lista de pagos.
     * 
     * @param payments Lista de pagos para calcular el pago medio.
     * @return         El pago medio de la lista de pagos.
     */
    private BigDecimal calculateAveragePayment(List<Payment> payments) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (Payment payment : payments) {
            totalAmount = totalAmount.add(payment.getAmount());
        }
        return payments.isEmpty() ? BigDecimal.ZERO : totalAmount.divide(BigDecimal.valueOf(payments.size()), 2, RoundingMode.HALF_UP);
    }
    
    /**
     * Calcula la fecha del primer y último pago realizado por cada cliente.
     *
     * @return Lista de arrays de objetos que contienen el nombre y apellidos del cliente, así como la fecha del primer y último pago.
     */
    public List<Object[]> findFirstAndLastPaymentDatesForCustomers() {
        return paymentRepository.findFirstAndLastPaymentDatesForCustomers();
    }

    /**
     * Encuentra la suma total de los pagos agrupados por año.
     * @return Lista de arreglos de objetos, donde cada arreglo contiene el año y la suma total de pagos para ese año.
     */
    public List<Object[]> findTotalPaymentsByYear() {
        return paymentRepository.findTotalPaymentsByYear();
    }

    /**
     * Obtiene el nombre de los clientes que han hecho pagos y el nombre de sus representantes
     * junto con la ciudad de la oficina a la que pertenece el representante.
     * @return Lista de objetos que contienen el nombre del cliente, nombre del representante, apellido del representante
     * y ciudad de la oficina.
     */
    public List<Object[]> findCustomerPaymentsAndRepresentatives() {
        return paymentRepository.findCustomerPaymentsAndRepresentatives();
    }
}