package com.JuanGreenGarden.Gardening.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JuanGreenGarden.Gardening.domain.Exceptions.InvalidIdFormatException;
import com.JuanGreenGarden.Gardening.domain.Exceptions.NotFoundEndPoint;
import com.JuanGreenGarden.Gardening.domain.service.EmployeeService;
import com.JuanGreenGarden.Gardening.persistence.entity.Employee;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.EmployeeDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

/**
 * Controlador REST para operaciones relacionadas con los empleados.
 */
@RestController
@RequestMapping("/api/employees")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Obtiene todos los empleados.
     * 
     * @return Una respuesta con una lista de todos los empleados.
     */
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * Obtiene un empleado por su ID.
     * 
     * @param employeeId El ID del empleado a obtener.
     * @return Una respuesta con el empleado correspondiente al ID especificado.
     * @throws InvalidIdFormatException Si el formato del ID del empleado es inválido.
     * @throws NotFoundEndPoint Si no se encuentra el empleado con el ID especificado.
     */
    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String employeeId) {
        try {
            Integer id = Integer.parseInt(employeeId);
            Employee employee = employeeService.getEmployeeById(id);
            if(employee != null){
                return new ResponseEntity<>(employee, HttpStatus.OK);
            } else {
                throw new NotFoundEndPoint("Employee with ID " + id + " not found");
            }
        } catch (NumberFormatException e) {
            throw new InvalidIdFormatException("Invalid format for employee ID: " + employeeId);
        }
    }

    /**
     * Obtiene los empleados de un jefe.
     * 
     * @return Una respuesta con una lista de empleados que tienen el jefe con el ID especificado.
     */
    @GetMapping("/boss-employees")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByBossId() {
        Integer bossId = 7;
        List<EmployeeDTO> employees = employeeService.getEmployeesByBossId(bossId);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * Obtiene los detalles del jefe.
     * 
     * @return Una respuesta con los detalles del jefe, si existe.
     * @throws NotFoundEndPoint Si no se encuentra el jefe.
     */
    @GetMapping("/boss")
    public ResponseEntity<EmployeeDTO> getBossDetails() {
        EmployeeDTO bossDetails = employeeService.getBossDetails();
        if (bossDetails != null) {
            return new ResponseEntity<>(bossDetails, HttpStatus.OK);
        } else {
            throw new NotFoundEndPoint("Boss details not found");
        }
    }

    /**
     * Obtiene los empleados que no son representantes de ventas.
     * 
     * @return Una respuesta con una lista de empleados que no tienen el título "Representante Ventas".
     */
    @GetMapping("/non-sales-representatives")
    public ResponseEntity<List<EmployeeDTO>> getNonSalesRepresentatives() {
        List<EmployeeDTO> employees = employeeService.getEmployeesNotSalesRepresentatives();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    } 
}
