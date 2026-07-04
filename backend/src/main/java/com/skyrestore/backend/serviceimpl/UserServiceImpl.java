package com.skyrestore.backend.serviceimpl;

import org.springframework.stereotype.Service;

import com.skyrestore.backend.DTO.response.UserResponse;
import com.skyrestore.backend.Entity.User;
import com.skyrestore.backend.mapper.UserMapper;
import com.skyrestore.backend.repository.UserRepository;
import com.skyrestore.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository,
                           UserMapper userMapper) {

        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse getCurrentUser(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return userMapper.toResponse(user);
    }
}