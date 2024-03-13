package com.JuanGreenGarden.Gardening.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JuanGreenGarden.Gardening.persistence.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {
    
}
