package com.JuanGreenGarden.Gardening.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
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


    /**
     * Encuentra clientes con pedidos pero sin pagos.
     *
     * @return Lista de clientes que tienen pedidos pero no pagos.
     */
    List<Customer> findByCustomersIsNotNullAndCustomers2IsEmpty();

    
    /**
     * Cuenta la cantidad de clientes por país.
     *
     * @return Lista de arreglos de objetos donde cada arreglo contiene el nombre del país y la cantidad de clientes.
     */
    @Query("SELECT c.country, COUNT(c) FROM Customer c GROUP BY c.country")
    List<Object[]> countCustomersByCountry();

    /**
     * Calcula el número total de clientes.
     *
     * @return El número total de clientes.
     */
    long count();

    /**
     * Cuenta el número de clientes con domicilio en la ciudad de Madrid.
     *
     * @param city La ciudad para la cual se desea contar los clientes.
     * @return El número de clientes con domicilio en la ciudad de Madrid.
     */
    long countByCity(String city);

    /**
     * Cuenta el número de clientes por ciudad que comienza con la letra "M".
     *
     * @param cityPrefix Prefijo de la ciudad para filtrar las ciudades que comienzan con la letra "M".
     * @return Lista de objetos Object[], donde el primer elemento es el nombre de la ciudad y el segundo elemento es el número de clientes en esa ciudad.
     */
    List<Object[]> countCustomersByCityStartingWith(String cityPrefix);

    /**
     * Consulta personalizada para contar el número de clientes que no tienen asignado un representante de ventas.
     *
     * @return El número de clientes sin representante de ventas asignado.
     */
    @Query("SELECT COUNT(c) FROM Customer c WHERE c.employeeField IS NULL")
    long countCustomersWithoutSalesRepresentative();

    
    /**
     * Encuentra todos los clientes.
     *
     * @return Una lista de todos los clientes.
     */
    List<Customer> findAll();

    /**
     * Encuentra los detalles de los clientes que no tienen pagos asociados y los representantes de ventas
     * con el nombre de su jefe y la ciudad de la oficina.
     *
     * @return Una lista de matrices de objetos que contienen el nombre del cliente, el nombre y apellido
     * del representante de ventas, y la ciudad de la oficina.
     */
    @Query("SELECT c.customerName, e.firstName, e.lastName1, o.city FROM Customer c " +
            "JOIN c.employeeField e " +
            "JOIN e.officeField o " +
            "WHERE c NOT IN (SELECT p.customerField2 FROM Payment p)")
    List<Object[]> findCustomersWithoutPaymentsAndRepresentatives();


    /**
     * Obtiene los nombres de los clientes y los representantes de ventas junto con la ciudad de la oficina
     * a la que están asignados.
     *
     * @return Una lista de matrices de objetos que contienen el nombre del cliente, el nombre y apellido
     * del representante de ventas, y la ciudad de la oficina.
     */
    @Query("SELECT c.customerName, e.firstName, e.lastName1, o.city " +
    "FROM Customer c " +
    "JOIN c.employeeField e " +
    "JOIN e.officeField o")
    List<Object[]> getCustomerNamesAndRepresentativesWithOfficeCity();
}
