package com.taskflow.taskflow.service;

import com.taskflow.taskflow.model.Task;
import java.util.UUID;

public interface TaskService {
    // Kontrak fungsi untuk membuat tugas baru yang terikat pada User ID tertentu
    Task createTask(Task task, UUID userId);
}