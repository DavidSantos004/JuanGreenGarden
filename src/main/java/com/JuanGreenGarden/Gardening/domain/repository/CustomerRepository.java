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

}
