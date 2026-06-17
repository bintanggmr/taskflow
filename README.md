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

- **Hari 14:** Melakukan pengujian end-to-end API Registrasi (Skenario Sukses & Gagal) dan menyusun dokumentasi API kontrak pada file README.md.
## 🔌 API Documentation (Endpoint Pengujian)

### 1. Registrasi Pengguna Baru
- **Endpoint:** `POST /api/users/register`
- **Headers:** `Content-Type: application/json`
- **Request Body Example:**
```json
{
  "username": "bintangbisa",
  "email": "bintang@taskflow.com",
  "password": "password123",
  "role": "USER"
}

Response Success (201 Created):

{
  "id": "f47ac10b-58cc-4372-a567-0e02b2c3d479",
  "username": "bintangbisa",
  "email": "bintang@taskflow.com",
  "password": "password123",
  "role": "USER"
}

Response Fail (400 Bad Request):

Error: Email sudah terdaftar!

- **Hari 15:** Implementasi lapisan keamanan data pertama dengan menerapkan Password Hashing (SHA-256/Base64) pada Service Layer sebelum data disimpan ke database.

- **Hari 16:** Membuat Data Transfer Object (`LoginRequest` DTO) dan mengimplementasikan logika bisnis otentikasi login serta verifikasi password hash pada Service Layer.

### 2. Otentikasi Login Pengguna
- **Endpoint:** `POST /api/users/login`
- **Headers:** `Content-Type: application/json`
- **Request Body Example:**
```json
{
  "email": "bintang@taskflow.com",
  "password": "password123"
}

Response Success (200 OK):

{
  "id": "f47ac10b-58cc-4372-a567-0e02b2c3d479",
  "username": "bintangbisa",
  "email": "bintang@taskflow.com",
  "password": "pmWkWSBCL51B...",
  "role": "USER"
}

Response Fail (401 Unauthorized):

Error: Password salah!

- **Hari 18:** Inisiasi fitur utama manajemen tugas dengan mengimplementasikan entitas `Task` dan memetakan relasi `@ManyToOne` ke entitas `User`.

- **Hari 19:** Implementasi Data Access Layer untuk fitur tugas dengan membuat `TaskRepository` dan menambahkan kueri kustom relasional (`findByUserId`).

- **Hari 20:** Implementasi Service Layer untuk fitur tugas dengan membuat interface `TaskService` dan kelas `TaskServiceImpl` untuk menangani logika bisnis pembuatan tugas baru secara relasional.

### 3. Manajemen Tugas (Tasks)
- **Endpoint:** `POST /api/tasks?userId=UUID_PENGGUNA_DISINI`
- **Headers:** `Content-Type: application/json`
- **Request Body Example:**
```json
{
  "title": "Implementasi OIDC Keycloak",
  "description": "Menyusun konfigurasi identity brokering menggunakan Keycloak dan Docker sesuai standard FAL 1",
  "dueDate": "2026-06-30T23:59:00"
}

Response Success (201 Created):

{
  "id": "a1b2c3d4-e5f6-7a8b-9c0d-1e2f3a4b5c6d",
  "title": "Implementasi OIDC Keycloak",
  "description": "Menyusun konfigurasi identity brokering menggunakan Keycloak dan Docker sesuai standard FAL 1",
  "status": "TODO",
  "dueDate": "2026-06-30T23:59:00"
}

Hari 21: Implementasi Controller Layer untuk fitur manajemen tugas dengan mengekspos endpoint POST /api/tasks menggunakan kombinasi RequestBody JSON dan RequestParam URL.