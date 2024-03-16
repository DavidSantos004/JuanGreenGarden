package com.JuanGreenGarden.Gardening.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JuanGreenGarden.Gardening.persistence.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

    Admin findByUsername(String username);
} 