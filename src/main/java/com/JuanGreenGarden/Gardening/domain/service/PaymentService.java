package com.JuanGreenGarden.Gardening.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.PaymentRepository;
import com.JuanGreenGarden.Gardening.domain.repository.ProductLineRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.Payment;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Integer paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

    public Payment createOrUpdatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePayment(Integer paymentId) {
        paymentRepository.deleteById(paymentId);
    }
}
