package com.taskflow.taskflow.controller;

import com.taskflow.taskflow.model.User;
import com.taskflow.taskflow.dto.LoginRequest;
import com.taskflow.taskflow.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // KONTRIBUSI HARI 17: Menggunakan Constructor Injection (Standar Industri)
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint Registrasi (Fitur Sebelumnya)
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // KONTRIBUSI HARI 17: Endpoint untuk Login/Otentikasi Pengguna
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        try {
            User authenticatedUser = userService.loginUser(loginRequest);
            // Jika sukses, kembalikan data user dengan status 200 OK
            return new ResponseEntity<>(authenticatedUser, HttpStatus.OK);
        } catch (RuntimeException e) {
            // Menangkap error jika email tidak ketemu atau password salah (status 401 Unauthorized)
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}