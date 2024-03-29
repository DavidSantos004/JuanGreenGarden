package com.JuanGreenGarden.Gardening.domain.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JuanGreenGarden.Gardening.persistence.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {
    
    /**
     * Busca empleados por el número de su jefe.
     * 
     * @param employeeNumber El número del jefe de los empleados a buscar.
     * @return Una lista de empleados que tienen el jefe con el número especificado.
     */
    List<Employee> findByEmployeeField2EmployeeNumber(Integer employeeNumber);

    /**
     * Busca el jefe que no tiene a nadie por encima.
     * 
     * @return El empleado que no tiene jefe.
     */
    Employee findByEmployeeField2IsNull();

    /**
     * Busca empleados que no tienen un título de trabajo específico.
     * 
     * @param jobTitle El título de trabajo que los empleados no deben tener.
     * @return Una lista de empleados que no tienen el título de trabajo especificado.
     */
    List<Employee> findByJobTitleNot(String jobTitle);


    /**
     * Encuentra una lista de empleados que no tienen una oficina asociada.
     *
     * @return Lista de empleados sin una oficina asociada
     */
    List<Employee> findByOfficeFieldIsNull();

    /**
     * Recupera una lista de empleados que no tienen clientes asociados.
     *
     * @return Lista de empleados sin clientes asociados.
     */
    List<Employee> findByEmployeesIsNull();

    /**
     * Busca una lista de empleados que no tienen clientes asociados y tienen una oficina asignada.
     *
     * @return Lista de empleados sin clientes asociados y con una oficina asignada
     */
    List<Employee> findByEmployeesIsEmptyAndOfficeFieldIsNotNull();

    /**
     * Busca y devuelve una lista de empleados cuyo campo de oficina (officeField) es nulo
     * y la lista de empleados asociados también está vacía.
     *
     * @return Una lista de empleados que cumplen los criterios especificados.
     */
    List<Employee> findByOfficeFieldIsNullAndEmployeesIsEmpty();

    /**
     * Método para contar el número de empleados en la compañía.
     *
     * @return El número total de empleados.
     */
    long count();


    /**
     * Consulta personalizada para contar el número de clientes atendidos por cada representante de ventas.
     * 
     * @return Una lista de arrays de objetos donde cada array contiene el nombre del representante de ventas y el número de clientes que atiende.
     */
    @Query("SELECT e.firstName, COUNT(c) " +
            "FROM Employee e " +
            "LEFT JOIN e.employees c " +
            "GROUP BY e.firstName")
    List<Object[]> countCustomersBySalesRepresentative();
    

    /**
     * Obtiene una lista de nombres de empleados junto con los nombres de sus jefes.
     *
     * @return Lista de arrays de objetos que contienen el primer nombre y el primer apellido del empleado,
     * seguido del primer nombre y el primer apellido de su jefe, en caso de éxito.
     */
    @Query("SELECT e.firstName, e.lastName1, e2.firstName, e2.lastName1 " +
           "FROM Employee e " +
           "LEFT JOIN e.employeeField2 e2")
    List<Object[]> getEmployeeNamesAndBossNames();

     /**
     * Obtiene una lista de nombres de empleados junto con los nombres de sus jefes y los nombres de los jefes
     * de sus jefes (abuelos).
     *
     * @return Lista de arrays de objetos que contienen el primer nombre del empleado, el primer nombre de su jefe,
     * y el primer nombre del jefe de su jefe (abuelo), en caso de éxito.
     */
    @Query("SELECT e.firstName, e.employeeField2.firstName, e.employeeField2.employeeField2.firstName FROM Employee e")
    List<Object[]> getEmployeeNamesAndBossesAndGrandBosses();
    

    /**
     * Encuentra una lista de empleados que no tienen clientes asociados.
     *
     * @return Lista de empleados que no tienen clientes asociados, en caso de éxito.
     */
    @Query("SELECT e FROM Employee e WHERE e NOT IN " +
           "(SELECT c.employeeField FROM Customer c)")
    List<Employee> findEmployeesWithoutCustomers();
}
