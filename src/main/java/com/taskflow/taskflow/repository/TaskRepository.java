package com.taskflow.taskflow.repository;

import com.taskflow.taskflow.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    
    List<Task> findByUserId(UUID userId);
    
    // UTAMAKAN YANG INI: Tambahkan underscore (_) untuk mempertegas relasi Task -> User -> Id
    List<Task> findByUser_IdAndStatus(UUID userId, String status);
}