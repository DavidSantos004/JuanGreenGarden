package com.JuanGreenGarden.Gardening.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.JuanGreenGarden.Gardening.domain.repository.AdminRepository;
import com.JuanGreenGarden.Gardening.persistence.entity.Admin;

@Service
public class AdminInterfaceImpl implements AdminInterface<Admin>{

    private final AdminRepository adminRepository;

    @Autowired
    public AdminInterfaceImpl(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @Override
    public ResponseEntity<Admin> save(Admin adminSave) {
        adminRepository.save(adminSave);
        return ResponseEntity.ok(adminSave);
    }



    

}
