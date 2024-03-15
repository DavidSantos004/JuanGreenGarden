package com.JuanGreenGarden.Gardening.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JuanGreenGarden.Gardening.domain.security.JWTAuthorizationConfig;
import com.JuanGreenGarden.Gardening.persistence.entity.UserProject;

@RestController
public class LoginController {
    
    @Autowired
    JWTAuthorizationConfig jwtAuthtenticationConfig;

    @PostMapping("login")
    public UserProject login(
            @RequestParam("newUser") String username,
            @RequestParam("encryptedPass") String encryptedPass) {
                


        String token = jwtAuthtenticationConfig.getJWTToken(username);
        return new UserProject(username, encryptedPass, token);
    }
}

