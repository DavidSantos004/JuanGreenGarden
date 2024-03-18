package com.JuanGreenGarden.Gardening.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JuanGreenGarden.Gardening.domain.repository.AdminRepository;
import com.JuanGreenGarden.Gardening.domain.security.JWTAuthorizationConfig;
import com.JuanGreenGarden.Gardening.persistence.entity.Admin;

@RestController
public class LoginController {
    
    @Autowired
    private JWTAuthorizationConfig jwtAuthtenticationConfig;

    @Autowired
    private AdminRepository adminRepository;

    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @PostMapping("/login")
    public String login(

            @RequestParam("username") String username,
            @RequestParam("password") String password) {
                
            Admin admin = adminRepository.findByUsername(username);

            if (admin != null && admin.getPassword().equals(password)) {
                String token = jwtAuthtenticationConfig.getJWTToken(username);
                adminRepository.save(admin);
                return token;
            } else {
                throw new RuntimeException("Invalid credentials");
            }
    }


}

