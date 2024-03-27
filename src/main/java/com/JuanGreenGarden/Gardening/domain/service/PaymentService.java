package com.JuanGreenGarden.Gardening.domain.service;

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
}