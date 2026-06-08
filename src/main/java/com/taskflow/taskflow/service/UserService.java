package com.taskflow.taskflow.service;

import com.taskflow.taskflow.model.User;

public interface UserService {
    // Kontrak fungsi untuk mendaftarkan user baru
    User registerUser(User user);
}