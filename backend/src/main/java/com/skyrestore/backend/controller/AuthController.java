package com.skyrestore.backend.controller;

import org.springframework.web.bind.annotation.*;

import com.skyrestore.backend.DTO.request.LoginRequest;
import com.skyrestore.backend.DTO.request.RegisterRequest;
import com.skyrestore.backend.DTO.response.AuthResponse;
import com.skyrestore.backend.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    // Constructor Injection
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}