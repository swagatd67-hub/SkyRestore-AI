package com.skyrestore.backend.service;

import com.skyrestore.backend.DTO.response.UserResponse;

public interface UserService {

    UserResponse getCurrentUser(String email);

}