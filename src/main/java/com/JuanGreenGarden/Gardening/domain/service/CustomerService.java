package com.JuanGreenGarden.Gardening.domain.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.CustomerRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.Customer;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.CustomerDTO;

import jakarta.persistence.TypedQuery;

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


    /**
     * Obtiene una lista de clientes que han realizado pagos.
     *
     * @return Lista de clientes con pagos realizados
     */
    public List<Customer> getCustomersWithPayments() {
        return customerRepository.findByCustomers2IsNotNull();
    }

    /**
     * Obtiene una lista de clientes que **no** han realizado pagos.
     *
     * @return Lista de clientes sin pagos realizados
     */
    public List<Customer> getCustomersWithoutPayments() {
        return customerRepository.findByCustomers2IsNull();
    }

   /**
     * Obtiene una lista de clientes que **no** han realizado pedidos.
     *
     * @return Lista de clientes sin pedidos realizados
     */
    public List<Customer> getCustomersWithoutOrders() {
        return customerRepository.findByCustomersIsEmpty();
    }
    
    /**
     * Obtiene una lista de clientes que no han realizado pedidos ni pagos.
     *
     * @return Lista de clientes sin pedidos ni pagos realizados
     */
    public List<Customer> getCustomersWithoutOrdersAndPayments() {
        return customerRepository.findByCustomersIsEmptyAndCustomers2IsEmpty();
    }

    /**
     * Encuentra clientes con pedidos pero sin pagos.
     *
     * @return Lista de clientes que tienen pedidos pero no pagos.
     */
    public List<Customer> findCustomersWithOrdersButNoPayments() {
        return customerRepository.findByCustomersIsNotNullAndCustomers2IsEmpty();
    }

    /**
     * Cuenta la cantidad de clientes por país.
     *
     * @return Lista de arreglos de objetos donde cada arreglo contiene el nombre del país y la cantidad de clientes.
     */
    public List<Object[]> countCustomersByCountry() {
        return customerRepository.countCustomersByCountry();
    }

    /**
     * Calcula el número total de clientes.
     *
     * @return El número total de clientes.
     */
    public long countCustomers() {
        return customerRepository.count();
    }

    /**
     * Cuenta el número de clientes con domicilio en la ciudad de Madrid.
     *
     * @return El número de clientes con domicilio en la ciudad de Madrid.
     */
    public long countCustomersInMadrid() {
        return customerRepository.countByCity("Madrid");
    }

    /**
     * Calcula el número de clientes por ciudad que comienza con la letra "M".
     *
     * @return Lista de objetos Object[], donde el primer elemento es el nombre de la ciudad y el segundo elemento es el número de clientes en esa ciudad.
     */
    public List<Object[]> countCustomersByCityStartingWithM() {
        return customerRepository.countCustomersByCityStartingWith("M");
    }

    /**
     * Calcula el número de clientes que no tienen asignado un representante de ventas.
     *
     * @return El número de clientes sin representante de ventas asignado.
     */
    public long countCustomersWithoutSalesRepresentative() {
        return customerRepository.countCustomersWithoutSalesRepresentative();
    }

    

    /**
     * Obtiene todos los clientes.
     *
     * @return Una lista de todos los clientes.
     */
    public List<Customer> getAllCustomerss() {
        return customerRepository.findAll();
    }


    /**
     * Obtiene el nombre de los clientes que no hayan hecho pagos y el nombre de sus representantes
     * junto con la ciudad de la oficina a la que pertenece el representante.
     * @return Lista de objetos que contienen el nombre del cliente, nombre del representante, apellido del representante
     * y ciudad de la oficina.
     */
    public List<Object[]> findCustomersWithoutPaymentsAndRepresentatives() {
        return customerRepository.findCustomersWithoutPaymentsAndRepresentatives();
    }


    /**
     * Obtiene los nombres de los clientes y los representantes de ventas junto con la ciudad de la oficina
     * a la que están asignados.
     *
     * @return Una lista de matrices de objetos que contienen el nombre del cliente, el nombre y apellido
     * del representante de ventas, y la ciudad de la oficina.
     */
    public List<Object[]> getCustomerNamesAndRepresentativesWithOfficeCity() {
        return customerRepository.getCustomerNamesAndRepresentativesWithOfficeCity();
    }
}
