package com.taskflow.taskflow.controller;

import com.taskflow.taskflow.model.Task;
import com.taskflow.taskflow.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    // KONTRIBUSI HARI 21: Constructor Injection agar bersih dari warning
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Endpoint untuk membuat tugas baru dan mengaitkannya ke User ID tertentu
    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task, @RequestParam UUID userId) {
        try {
            Task createdTask = taskService.createTask(task, userId);
            // Jika sukses, kembalikan data tugas dengan status 201 Created
            return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Menangkap error jika User ID tidak ditemukan di database (status 400 Bad Request)
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasksByUserId(@RequestParam UUID userId) {
        List<Task> tasks = taskService.getTasksByUserId(userId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}