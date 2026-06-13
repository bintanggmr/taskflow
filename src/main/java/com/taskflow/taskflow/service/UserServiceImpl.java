package com.taskflow.taskflow.service;

import com.taskflow.taskflow.model.User;
import com.taskflow.taskflow.dto.LoginRequest;
import com.taskflow.taskflow.repository.UserRepository;
import com.taskflow.taskflow.util.PasswordUtil;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // Buat fungsi konstruktor secara eksplisit
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Error: Email sudah terdaftar!");
        }
        String securedPassword = PasswordUtil.hashPassword(user.getPassword());
        user.setPassword(securedPassword);
        return userRepository.save(user);
    }

    // KONTRIBUSI HARI 16: Logika Bisnis Otentikasi Login
    @Override
    public User loginUser(LoginRequest loginRequest) {
        // 1. Cari user berdasarkan email lewat kueri database (menggunakan findByUsername yang dimodifikasi atau buat baru)
        // Agar rapi, kita cari berdasarkan username/email. Karena di repo kemarin kita baru buat findByUsername,
        // Mari kita cari menggunakan aliran stream data sederhana atau kustom kueri.
        // Untuk efisiensi, kita asumsikan mencari user dari database.
        
        User user = userRepository.findAll().stream()
                .filter(u -> u.getEmail().equals(loginRequest.getEmail()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Error: Email tidak ditemukan!"));

        // 2. Hash password inputan user dan cocokkan dengan yang ada di database
        String encryptedInputPassword = PasswordUtil.hashPassword(loginRequest.getPassword());
        if (!user.getPassword().equals(encryptedInputPassword)) {
            throw new RuntimeException("Error: Password salah!");
        }

        // 3. Jika cocok, kembalikan data user (Login Sukses)
        return user;
    }
}