package com.JuanGreenGarden.Gardening.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.EmployeeRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.Employee;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.EmployeeDTO;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Obtiene todos los empleados.
     * 
     * @return Una lista de todos los empleados.
     */
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(Employee::toDTO)
                .toList();
    } 

    /**
     * Obtiene un empleado por su ID.
     * 
     * @param employeeId El ID del empleado a obtener.
     * @return El empleado correspondiente al ID especificado, o null si no se encuentra.
     */
    public Employee getEmployeeById(Integer employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    /**
     * Obtiene los empleados por el ID de su jefe.
     * 
     * @param bossId El ID del jefe de los empleados a obtener.
     * @return Una lista de empleados que tienen el jefe con el ID especificado.
     */
    public List<EmployeeDTO> getEmployeesByBossId(Integer bossId) {
        List<Employee> employees = employeeRepository.findByEmployeeField2EmployeeNumber(bossId);
        return employees.stream()
                .map(Employee::toDTO)
                .toList();
    }

    /**
     * Obtiene los detalles del jefe.
     * 
     * @return Los detalles del jefe, si existe.
     */
    public EmployeeDTO getBossDetails() {
        Employee boss = employeeRepository.findByEmployeeField2IsNull();
        return boss != null ? boss.toDTO() : null;
    }

    /**
     * Obtiene los empleados que no son representantes de ventas.
     * 
     * @return Una lista de empleados que no tienen el título de trabajo "Representante Ventas".
     */
    public List<EmployeeDTO> getEmployeesNotSalesRepresentatives() {
        return employeeRepository.findByJobTitleNot("Representante Ventas").stream()
                .map(Employee::toDTO)
                .toList();
    }

/**
     * Obtiene una lista de empleados que no tienen una oficina asociada.
     *
     * @return Lista de empleados sin una oficina asociada
     */
    public List<Employee> getEmployeesWithoutOffice() {
        return employeeRepository.findByOfficeFieldIsNull();
    }
    
    
    /**
     * Obtiene una lista de empleados que no tienen clientes asociados.
     * @return Lista de empleados sin clientes asociados.
     */
    public List<Employee> getEmployeesWithoutCustomers() {
        return employeeRepository.findByEmployeesIsNull();
    }

    /**
     * Obtiene una lista de empleados que no tienen clientes asociados y tienen una oficina asignada.
     *
     * @return Lista de empleados sin clientes asociados y con una oficina asignada
     */
    public List<Employee> getEmployeesWithoutCustomersAndOffice() {
        return employeeRepository.findByEmployeesIsEmptyAndOfficeFieldIsNotNull();
    }

    /**
     * Obtiene una lista de empleados que no tienen una oficina asociada ni un cliente asociado.
     *
     * @return Lista de empleados sin una oficina asociada ni un cliente asociado
     */
    public ResponseEntity<?> getEmployeesWithoutOfficeAndCustomer() {
        List<Employee> employees = employeeRepository.findByOfficeFieldIsNullAndEmployeesIsEmpty();
        if (employees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron empleados sin una oficina asociada ni un cliente asociado.");
        } else {
            return ResponseEntity.ok(employees);
        }
    }

/**
     * Método para obtener el número total de empleados en la compañía.
     *
     * @return El número total de empleados.
     */    public long getTotalEmployees() {
        return employeeRepository.count();
    }

     /**
     * Recupera el nombre de los representantes de ventas y el número de clientes que atiende cada uno.
     * 
     * @return Una lista de arrays de objetos donde cada array contiene el nombre del representante de ventas y el número de clientes que atiende.
     */
    public List<Object[]> countCustomersBySalesRepresentative() {
        return employeeRepository.countCustomersBySalesRepresentative();
    }

    /**
     * Obtiene los nombres de los empleados y sus jefes directos.
     *
     * @return Lista de matrices de objetos que contienen los nombres de los empleados y sus jefes directos.
     */
    public List<Object[]> getEmployeeNamesAndBossNames() {
        return employeeRepository.getEmployeeNamesAndBossNames();
    }

    /**
     * Obtiene los nombres de los empleados, sus jefes y sus jefes superiores.
     *
     * @return Lista de matrices de objetos que contienen los nombres de los empleados, sus jefes y sus jefes superiores.
     */
    public List<Object[]> getEmployeeNamesAndBossesAndGrandBosses() {
        return employeeRepository.getEmployeeNamesAndBossesAndGrandBosses();
    }

    /**
     * Encuentra los empleados que no tienen clientes asociados.
     *
     * @return Lista de empleados sin clientes asociados.
     */
    public List<Employee> findEmployeesWithoutCustomers() {
        return employeeRepository.findEmployeesWithoutCustomers();
    }
}
