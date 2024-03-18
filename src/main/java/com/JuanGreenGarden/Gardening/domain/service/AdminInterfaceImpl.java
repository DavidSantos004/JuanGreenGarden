package com.JuanGreenGarden.Gardening.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.AdminRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.Admin;

@Service
public class AdminInterfaceImpl implements AdminInterface<Admin> {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminInterfaceImpl(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public ResponseEntity<Admin> save(Admin adminSave) {
        adminRepository.save(adminSave);
        return ResponseEntity.ok(adminSave);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }   
}