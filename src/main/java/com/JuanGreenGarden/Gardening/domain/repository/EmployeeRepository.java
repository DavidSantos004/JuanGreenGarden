package com.JuanGreenGarden.Gardening.domain.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
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

    List<Employee> findByOfficeFieldIsNullAndEmployeesIsEmpty();

    

    
}
