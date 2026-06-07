package com.taskflow.taskflow.repository;

import com.taskflow.taskflow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    
    // Kueri kustom otomatis untuk mencari user berdasarkan username
    Optional<User> findByUsername(String username);
    
    // Kueri kustom otomatis untuk memeriksa apakah email sudah terdaftar
    Boolean existsByEmail(String email);
}