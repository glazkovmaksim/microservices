package com.example.user_service.service;

import com.example.user_service.dto.ResponseDTO;
import com.example.user_service.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    ResponseDTO getUser(Long userId);
}
