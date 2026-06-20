package com.taskflow.taskflow.service;

import com.taskflow.taskflow.model.Task;
import java.util.UUID;
import java.util.List;

public interface TaskService {
    Task createTask(Task task, UUID userId);
    List<Task> getTasksByUserId(UUID userId);
    
    // KONTRIBUSI HARI 24: Kontrak fungsi untuk mengambil tugas berdasarkan ID User dan Status
    List<Task> getTasksByUserIdAndStatus(UUID userId, String status);
}