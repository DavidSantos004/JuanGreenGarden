package com.JuanGreenGarden.Gardening.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JuanGreenGarden.Gardening.domain.service.AdminInterfaceImpl;
import com.JuanGreenGarden.Gardening.persistence.entity.Admin;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5501")
@RequestMapping("/register")
public class AdminController {
    private final AdminInterfaceImpl adminInterfaceImpl;

    @Autowired
    public AdminController(AdminInterfaceImpl adminInterfaceImpl) {
        this.adminInterfaceImpl = adminInterfaceImpl;
    }
    @GetMapping
    public List<Admin> getAllAdmins(){
        return adminInterfaceImpl.getAll();
    }

    @PostMapping
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin adminSave) {
        return adminInterfaceImpl.save(adminSave);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        return adminInterfaceImpl.delete(id);
    }

    
}
