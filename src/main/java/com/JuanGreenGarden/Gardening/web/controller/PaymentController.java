package com.JuanGreenGarden.Gardening.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JuanGreenGarden.Gardening.domain.Exceptions.DifferentDataTypeException;
import com.JuanGreenGarden.Gardening.domain.Exceptions.NotFoundEndPoint;
import com.JuanGreenGarden.Gardening.domain.service.PaymentService;
import com.JuanGreenGarden.Gardening.persistence.entity.Payment;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.PaymentDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

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

    @GetMapping
    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
        List<PaymentDTO> payments = paymentService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

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

}