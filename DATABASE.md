# Rancangan Skema Database - TaskFlow

Berikut adalah cetak biru relasi database menggunakan PostgreSQL untuk mendukung sistem manajemen tugas dan kolaborasi tim.

## 1. Tabel `users`
Mengelola data pengguna dan peran (*role*) akses sistem.
- `id` (UUID, Primary Key)
- `username` (VARCHAR, Unique)
- `email` (VARCHAR, Unique)
- `password` (VARCHAR, Hashed)
- `role` (VARCHAR) -- e.g., 'ADMIN', 'USER'

## 2. Tabel `projects`
Mengelola papan kerja atau ruang kolaborasi utama (Workspace).
- `id` (UUID, Primary Key)
- `name` (VARCHAR)
- `description` (TEXT)
- `created_by` (UUID, Foreign Key to `users.id`)
- `created_at` (TIMESTAMP)

## 3. Tabel `project_members` (Relasi Many-to-Many)
Menghubungkan pengguna yang tergabung ke dalam suatu proyek tertentu.
- `project_id` (UUID, Foreign Key to `projects.id`)
- `user_id` (UUID, Foreign Key to `users.id`)
- Primary Key (`project_id`, `user_id`)

## 4. Tabel `tasks`
Mengelola detail tugas yang ada di dalam proyek.
- `id` (UUID, Primary Key)
- `project_id` (UUID, Foreign Key to `projects.id`)
- `title` (VARCHAR)
- `description` (TEXT)
- `status` (VARCHAR) -- 'TODO', 'IN_PROGRESS', 'DONE'
- `priority` (VARCHAR) -- 'LOW', 'MEDIUM', 'HIGH'
- `assignee_id` (UUID, Foreign Key to `users.id`, Nullable)
- `due_date` (TIMESTAMP)