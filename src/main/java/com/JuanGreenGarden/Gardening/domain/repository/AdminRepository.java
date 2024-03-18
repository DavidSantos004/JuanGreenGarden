package com.JuanGreenGarden.Gardening.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JuanGreenGarden.Gardening.persistence.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}
