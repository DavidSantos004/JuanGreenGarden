package com.JuanGreenGarden.Gardening.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JuanGreenGarden.Gardening.domain.Exceptions.InvalidIdFormatException;
import com.JuanGreenGarden.Gardening.domain.Exceptions.NotFoundEndPoint;
import com.JuanGreenGarden.Gardening.domain.service.EmployeeService;
import com.JuanGreenGarden.Gardening.persistence.entity.Employee;
import com.JuanGreenGarden.Gardening.persistence.entity.DTO.EmployeeDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

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

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

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

}