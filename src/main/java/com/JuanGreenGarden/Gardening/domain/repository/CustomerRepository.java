package com.JuanGreenGarden.Gardening.domain.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.JuanGreenGarden.Gardening.persistence.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    
    /**
     * Busca clientes por país.
     * 
     * @param country El país de los clientes a buscar.
     * @return Una lista de clientes que pertenecen al país especificado.
     */
    List<Customer> findByCountry(String country);

    /**
     * Busca clientes por ciudad y números de representantes de ventas.
     * 
     * @param city La ciudad de los clientes a buscar.
     * @param employeeNumbers Los números de los representantes de ventas.
     * @return Una lista de clientes que están en la ciudad especificada y tienen representantes de ventas con los números especificados.
     */
    List<Customer> findByCityAndEmployeeField_EmployeeNumberIn(String city, List<Integer> employeeNumbers);

    
/**
     * Encuentra una lista de clientes que tienen pagos asociados.
     *
     * @return Lista de clientes con pagos asociados
     */
    List<Customer> findByCustomers2IsNotNull();


    /**
     * Encuentra una lista de clientes que **no** tienen pagos asociados.
     *
     * @return Lista de clientes sin pagos asociados
     */
    List<Customer> findByCustomers2IsNull();

    
    /**
     * Encuentra una lista de clientes que **no** han realizado pedidos.
     *
     * @return Lista de clientes sin pedidos realizados
     */
    List<Customer> findByCustomersIsEmpty();

    /**
     * Encuentra una lista de clientes que no han realizado pedidos ni pagos.
     *
     * @return Lista de clientes sin pedidos ni pagos realizados
     */
    List<Customer> findByCustomersIsEmptyAndCustomers2IsEmpty();


    List<Customer> findByCustomersIsNotNullAndCustomers2IsEmpty();

}
