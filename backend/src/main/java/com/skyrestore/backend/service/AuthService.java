package com.skyrestore.backend.service;

import com.skyrestore.backend.DTO.request.LoginRequest;
import com.skyrestore.backend.DTO.request.RegisterRequest;
import com.skyrestore.backend.DTO.response.AuthResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

}