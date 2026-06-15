package com.taskflow.taskflow.repository;

import com.taskflow.taskflow.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    
    // Kueri kustom otomatis untuk mengambil semua tugas milik user tertentu
    List<Task> findByUserId(UUID userId);
    
    // Kueri kustom otomatis untuk mencari tugas berdasarkan status milik user tertentu
    List<Task> findByUserIdAndStatus(UUID userId, String status);
}