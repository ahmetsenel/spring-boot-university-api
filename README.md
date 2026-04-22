# 🎓 University Management API

A **Spring Boot REST API** for managing university operations such as students, lecturers, courses, departments, and enrollments.  
The project includes authentication, role-based structure, and full CRUD functionality.

---

## 🚀 Features

- 🔐 Authentication & Authorization (JWT-based)
- 👨‍🎓 Student, Lecturer, Course, Department & Enrollment management
- 📚 Course enrollment system with grading support
- 🔒 Role-based security (ADMIN / USER)
- ⚡ Centralized exception handling system
- 🧩 MapStruct for object mapping
- 📄 DTO-based architecture (Request / Detail / Summary)
- 🔄 Clean layered architecture (Controller → Service → Repository)
- 📘 API documentation with Swagger (springdoc-openapi)

---

## 🛠️ Tech Stack

* **Java 17**
* **Spring Boot 3.5.13**
  * Spring Web
  * Spring Data JPA (Hibernate)
  * Spring Security
  * Spring Validation
* **JWT Authentication**
* **PostgreSQL**
* **Maven**
* **MapStruct**
* **Lombok**
* **SpringDoc OpenAPI (Swagger)**


---

## 📦 Project Structure

```bash
spring-boot-university-api/
│
├── src/main/java/com/ahmetsenel/universitymanagementapi/
│   │
│   ├── common/        # API response & error models
│   ├── config/        # Security & Swagger configuration
│   ├── controller/    # REST controllers
│   ├── dto/           # Request / Response DTOs
│   ├── entity/        # JPA entities & enums
│   ├── exception/     # Custom exceptions
│   ├── handler/       # Global & security exception handlers
│   ├── mapper/        # Entity ↔ DTO mapping
│   ├── repository/    # Data access layer
│   ├── security/      # JWT & security logic
│   ├── service/       # Business logic (interfaces & impl)
│   │
│   └── UniversityManagementApiApplication.java
│
├── src/main/resources/
│    └── application.properties
│
└── pom.xml
```

---


## 🔐 Authentication

- `POST /auth/register`

- `POST /auth/login`

### 🔑 Authorization Rules

| Role  | Description |
|------|-------------|
| 🛡️ **ADMIN** | Full access to all endpoints |
| 👤 **USER**  | Limited access: only `api/students/me` and `api/lecturers/me` |

### 🔐 Security Configuration

| Endpoint | Access Level |
|----------|-------------|
| `/api/auth/**` | 🌍 Public |
| `/api/swagger-ui.html/**` | 🌍 Public |
| `/api/students/me` | 👤 USER |
| `/api/lecturers/me` | 👤 USER |
| All other endpoints | 🛡️ ADMIN |

### 📌 Notes

- 🔐 Authentication is handled via **JWT (Bearer Token)**
- 🚫 Unauthorized requests return **401 Unauthorized**
- ⛔ Forbidden access returns **403 Forbidden**
- ⚙️ Security is stateless (no session storage)

---

## 📚 API Endpoints Overview

### 👤 Students

- `POST /students` → Create a new student
- `GET /students` → Get all students
- `GET /students/{id}` → Get student by ID
- `GET /students/{id}/courses` → Get courses of a student
- `GET /students/{id}/enrollments` → Get enrollments of a student
- `PATCH /students/{id}/advisor` → Update student's advisor
- `GET /students/me` → Get current authenticated student
- `DELETE /students/{id}` → Delete a student

### 👨‍🏫 Lecturers

- `POST /lecturers` → Create a new lecturer
- `GET /lecturers` → Get all lecturers
- `GET /lecturers/{id}` Get lecturer by ID
- `GET /lecturers/{id}/courses` → Get courses taught by lecturer
- `GET /lecturers/{id}/students` → Get students of lecturer
- `GET /lecturers/me` → Get current authenticated lecturer
- `DELETE /lecturers/{id}` → Delete a lecturer

### 📚 Courses

- `POST /courses` → Create a new course
- `GET /courses` → Get all courses
- `GET /courses/{id}` → Get course by ID
- `GET /courses/{id}/students` → Get students enrolled in course
- `DELETE /courses/{id}` → Delete a course

### 🏢 Departments

- `POST /departments` → Create a new department
- `GET /departments` → Get all departments
- `GET /departments/{id}` → Get department by ID
- `GET /departments/{id}/students` → Get students in department
- `GET /departments/{id}/lecturers` → Get lecturers in department
- `GET /departments/{id}/courses` → Get courses in department
- `DELETE /departments/{id}` → Delete a department

### 📝 Enrollments

- `POST /enrollments` → Enroll a student in a course
- `GET /enrollments` → Get all enrollments
- `GET /enrollments/{id}` → Get enrollment by ID
- `PATCH /enrollments/{id}/grade` → Update grade for enrollment
- `DELETE /enrollments/{id}` → Delete an enrollment

---

## 📄 API Response Format

All responses follow a standard wrapper:

```json
{
  "success": true,
  "message": "OK",
  "data": {}
}
```
---

## 🧪 Running the Project

### 🌐 Base URL

All endpoints are prefixed with:  
http://localhost:8080/api

### 1. Clone the repository
```bash
git clone https://github.com/ahmetsenel/spring-boot-university-api.git
cd spring-boot-university-api
```

### 2. Configure the database
Make sure PostgreSQL is running and update your application.properties file:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
spring.jpa.properties.hibernate.default_schema=YOUR_SCHEME
```

> ⚠️ Ensure the schema exists or create it manually:

```sql
CREATE SCHEMA IF NOT EXISTS YOUR_SCHEMA;
```

### 3. Install Dependencies & Build

Use Apache Maven to build the project:

```bash
mvn clean install
```

### 4. Run the Application

```bash
mvn spring-boot:run
```
---

## 📘 API Documentation

After running the project:
```bash
http://localhost:8080/api/swagger-ui.html
```

