package com.taskflow.taskflow.service;

import com.taskflow.taskflow.model.Task;
import java.util.UUID;
import java.util.List;

public interface TaskService {
    Task createTask(Task task, UUID userId);
    
    // KONTRIBUSI HARI 23: Kontrak fungsi untuk mengambil semua tugas milik user tertentu
    List<Task> getTasksByUserId(UUID userId);
}