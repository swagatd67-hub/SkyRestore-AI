package com.skyrestore.backend.mapper;

import org.springframework.stereotype.Component;

import com.skyrestore.backend.DTO.request.RegisterRequest;
import com.skyrestore.backend.Entity.User;
import com.skyrestore.backend.DTO.response.UserResponse;
@Component
public class UserMapper {

    public User toEntity(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        return user;
    }
    
    public UserResponse toResponse(User user) {

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }

}