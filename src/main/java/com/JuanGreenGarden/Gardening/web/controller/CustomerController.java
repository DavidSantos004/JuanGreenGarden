package com.JuanGreenGarden.Gardening.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.JuanGreenGarden.Gardening.domain.Exceptions.DifferentDataTypeException;
import com.JuanGreenGarden.Gardening.domain.Exceptions.InvalidIdFormatException;
import com.JuanGreenGarden.Gardening.domain.Exceptions.NotFoundEndPoint;
import com.JuanGreenGarden.Gardening.domain.service.CustomerService;
import com.JuanGreenGarden.Gardening.persistence.entity.Customer;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.CustomerDTO;



@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String customerId) {
        try {
            Integer id = Integer.parseInt(customerId);
            Customer customer = customerService.getCustomerById(id);
            if (customer != null) {
                return new ResponseEntity<>(customer, HttpStatus.OK);
            } else {
                throw new NotFoundEndPoint("Customer with ID " + id + " not found");
            }
        } catch (NumberFormatException e) {
            throw new InvalidIdFormatException("Invalid format for customer ID: " + customerId);
        }
}

}
