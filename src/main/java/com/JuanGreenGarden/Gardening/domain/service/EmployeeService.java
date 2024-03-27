package com.JuanGreenGarden.Gardening.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
