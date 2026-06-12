package com.taskflow.taskflow.service;

import com.taskflow.taskflow.model.User;
import com.taskflow.taskflow.dto.LoginRequest; // Import DTO baru

public interface UserService {
    User registerUser(User user);
    
    // Kontrak fungsi baru untuk login
    User loginUser(LoginRequest loginRequest);
}