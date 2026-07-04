package com.skyrestore.backend.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skyrestore.backend.DTO.response.UserResponse;
import com.skyrestore.backend.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public UserResponse getCurrentUser(Authentication authentication) {

        System.out.println("========== USER CONTROLLER ==========");

        if (authentication == null) {
            System.out.println("Authentication is NULL");
            throw new RuntimeException("Authentication is NULL");
        }

        System.out.println("Logged In User : " + authentication.getName());

        String email = authentication.getName();

        return userService.getCurrentUser(email);
    }
}