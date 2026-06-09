# TaskFlow - Sistem Manajemen Tugas & Kolaborasi Tim

TaskFlow adalah aplikasi web manajemen tugas berbasis kolaborasi tim yang dirancang dengan arsitektur backend yang bersih, aman, dan terstruktur.

## Tech Stack & Target Implementasi:
- Architecture: Clean Architecture / MVC
- Identity & Access Control: Role-Based Access Control (RBAC)

## Log Perkembangan Proyek:
- **Hari 6:** Inisialisasi proyek, setup repositori Git, dan pembuatan struktur dasar.

- **Hari 7:** Menentukan tech stack (Java Spring Boot, PostgreSQL, Docker) dan merancang skema database (tabel Users, Projects, Members, Tasks) dalam dokumen `DATABASE.md`.

- **Hari 8:** Inisialisasi struktur kode (boilerplate) Java Spring Boot 3.x menggunakan Spring Initializr dengan dependency Spring Web, JPA, dan PostgreSQL.

- **Hari 9:** Setup database PostgreSQL menggunakan Docker Compose dan mengonfigurasi koneksi database (`application.properties`) di Java Spring Boot.

- **Hari 10:** Membuat representasi objek database pertama (`User` Entity) menggunakan Jakarta Persistence (JPA) untuk pemetaan tabel pengguna otomatis.

- **Hari 11:** Implementasi Data Access Layer dengan membuat `UserRepository` yang mengekstensi `JpaRepository` untuk efisiensi operasi CRUD pada database.

- **Hari 12:** Implementasi Service Layer dengan membuat interface `UserService` dan kelas `UserServiceImpl` untuk menangani logika bisnis registrasi pengguna dan validasi email.

- **Hari 13:** Implementasi Controller Layer dengan membuat `UserController` dan mengekspos endpoint API `POST /api/users/register` untuk proses registrasi pengguna.