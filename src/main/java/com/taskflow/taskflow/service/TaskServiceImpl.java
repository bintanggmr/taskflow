package com.taskflow.taskflow.service;

import com.taskflow.taskflow.model.Task;
import com.taskflow.taskflow.model.User;
import com.taskflow.taskflow.repository.TaskRepository;
import com.taskflow.taskflow.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    // KONTRIBUSI HARI 20: Constructor Injection untuk multi-repository
    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Task createTask(Task task, UUID userId) {
        // 1. Validasi: Cari tahu apakah User ID pemilik tugas ini benar-benar ada di database
        User user = userRepository.findAll().stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Error: User tidak ditemukan!"));

        // 2. Hubungkan tugas dengan user yang sah tersebut (Set Foreign Key)
        task.setUser(user);

        // 3. Set status default tugas menjadi "TODO" jika belum ditentukan
        if (task.getStatus() == null || task.getStatus().isEmpty()) {
            task.setStatus("TODO");
        }

        // 4. Simpan data tugas ke PostgreSQL via TaskRepository
        return taskRepository.save(task);
    }
}