package com.JuanGreenGarden.Gardening.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.CustomerRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.Customer;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.CustomerDTO;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Obtiene un cliente por su ID.
     * 
     * @param customerId El ID del cliente a obtener.
     * @return El cliente correspondiente al ID especificado, o null si no se encuentra.
     */
    public Customer getCustomerById(Integer customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    /**
     * Obtiene todos los clientes.
     * 
     * @return Una lista de todos los clientes.
     */
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(Customer::toDTO)
                .toList();
    }    
   
    /**
     * Obtiene clientes españoles.
     * 
     * @return Una lista de clientes que son de España.
     */
    public List<CustomerDTO> getSpanishCustomers() {
        return customerRepository.findByCountry("Spain").stream()
                .map(Customer::toDTO)
                .toList();
    }

    /**
     * Obtiene clientes en Madrid con representantes de ventas.
     * 
     * @param employeeNumbers Los números de los representantes de ventas.
     * @return Una lista de clientes que están en Madrid y tienen representantes de ventas con los números especificados.
     */
    public List<Customer> getCustomersInMadridWithSalesRepresentatives(List<Integer> employeeNumbers) {
        return customerRepository.findByCityAndEmployeeField_EmployeeNumberIn("Madrid", employeeNumbers);
    }

    
}
