package com.JuanGreenGarden.Gardening.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.JuanGreenGarden.Gardening.domain.service.AdminInterfaceImpl;
import com.JuanGreenGarden.Gardening.persistence.entity.Admin;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/register")
public class AdminController {

    private final AdminInterfaceImpl adminServiceImpl;

    @Autowired
    public AdminController(AdminInterfaceImpl adminServiceImpl){
        this.adminServiceImpl = adminServiceImpl;
    }

    @PostMapping
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin adminSave) {
        return adminServiceImpl.save(adminSave);
    }

}
