# 🧠 Quiz System

A dynamic and extensible **Quiz System** built using **Java**, **Spring Boot**, and **PostgreSQL**, designed to manage quizzes, evaluate user submissions in real time, and demonstrate clean RESTful backend architecture. Ideal for learning platforms, coding assessments, and portfolio projects.

---

## 📌 Project Overview

This backend application enables:
- Quiz creation, update, and deletion
- Dynamic retrieval of questions for any quiz
- Real-time scoring based on user submissions
- JSON-based RESTful API communication
- Easy integration with frontend or mobile clients

Built following industry best practices in API design, error handling, and data persistence with PostgreSQL using Hibernate.

---

## 🛠️ Technology Stack

| Layer           | Technology                     |
|----------------|---------------------------------|
| Language        | Java (JDK 17+)                 |
| Framework       | Spring Boot                    |
| API Design      | Spring MVC / JAX-RS (Jersey)   |
| Database        | **PostgreSQL**                 |
| ORM             | Hibernate ORM                  |
| Build Tool      | Maven                          |
| Server          | Apache Tomcat 11               |
| IDE             | Eclipse / IntelliJ             |
| Tools           | Postman / Swagger (optional)   |

---

## 📂 Directory Structure

quiz-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.quizsystem/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── service/
│   │   │       └── repository/
│   │   └── resources/
│   │       └── application.properties
├── pom.xml
└── README.md


---

## 🔗 API Endpoints

| Method | Endpoint                | Description                      |
|--------|-------------------------|----------------------------------|
| `GET`  | `/api/quizzes`          | Fetch all quizzes                |
| `GET`  | `/api/questions/{id}`   | Get questions for a quiz         |
| `POST` | `/api/submit`           | Submit answers and get score     |
| `POST` | `/api/quiz`             | Create a new quiz (admin only)   |
| `PUT`  | `/api/quiz/{id}`        | Update quiz                      |
| `DELETE` | `/api/quiz/{id}`      | Delete quiz                      |

🔐 Optional: Secure admin routes using Spring Security and role-based access.

---

## ⚙️ Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/quiz-system.git
cd quiz-system

   2. Set Up PostgreSQL Database
- Install PostgreSQL and create a database named quizdb
- Set your database credentials (username, password) locally
- Use the following SQL snippet if you’d like to initialize manually:
CREATE DATABASE quizdb;

### 3.Configure application.properties
Update the following file: src/main/resources/application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/quizdb
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect





4. Build and Run the Project
Use Maven to install dependencies and start the server:
mvn clean install
mvn spring-boot:run


Once the application starts successfully, you can access it at:
http://localhost:8080/api



5. Test API Endpoints
You can use Postman, curl, or integrate Swagger for live testing.
Here’s an example request for quiz submission:
POST /api/submit
{
  "quizId": 1,
  "answers": {
    "q101": "B",
    "q102": "A",
    "q103": "C"
  }
}





