package com.skyrestore.backend.serviceimpl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skyrestore.backend.DTO.request.LoginRequest;
import com.skyrestore.backend.DTO.request.RegisterRequest;
import com.skyrestore.backend.DTO.response.AuthResponse;
import com.skyrestore.backend.Entity.User;
import com.skyrestore.backend.enums.Role;
import com.skyrestore.backend.mapper.UserMapper;
import com.skyrestore.backend.repository.UserRepository;
import com.skyrestore.backend.security.JwtService;
import com.skyrestore.backend.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final JwtService jwtService;

    // Constructor Injection
    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           UserMapper userMapper,
                           JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {

        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser.isPresent()) {
            return new AuthResponse("Email already exists", null);
        }

        User user = userMapper.toEntity(request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        if (request.getRole() == null) {
            user.setRole(Role.CITIZEN);
        }

        userRepository.save(user);

        String token = jwtService.generateToken(user.getEmail());

        return new AuthResponse("Registration Successful", token);
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());

        if (!optionalUser.isPresent()) {
            return new AuthResponse("Invalid Email", null);
        }

        User user = optionalUser.get();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return new AuthResponse("Invalid Password", null);
        }

        String token = jwtService.generateToken(user.getEmail());

        return new AuthResponse("Login Successful", token);
    }
}