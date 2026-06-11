package com.taskflow.taskflow.service;

import com.taskflow.taskflow.model.User;
import com.taskflow.taskflow.repository.UserRepository;
import com.taskflow.taskflow.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        // Logika Bisnis: Validasi apakah email sudah terdaftar di database
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Error: Email sudah terdaftar!");
        }

        // KONTRIBUSI HARI 15: Amankan password sebelum disimpan!
        String securedPassword = PasswordUtil.hashPassword(user.getPassword());
        user.setPassword(securedPassword);
        
        // Sementara password disimpan mentah dulu, nanti di tahap security kita akan hash!
        return userRepository.save(user);
    }
}