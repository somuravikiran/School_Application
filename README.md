# 🏫 School Application

A full-stack web application built with **Spring Boot** that provides a school management platform with contact form functionality, user authentication, and an admin dashboard.

---

## 🚀 Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend | Java 25, Spring Boot 4.0.1 |
| Web Framework | Spring MVC (spring-boot-starter-webmvc) |
| Security | Spring Security 7.0.2 |
| ORM | Hibernate 7.2 / Spring Data JPA |
| Database | MySQL 8.x |
| Templating | Thymeleaf 3.1 + Thymeleaf Security Extras |
| Validation | Hibernate Validator / Jakarta Validation |
| Build Tool | Maven |
| Dev Tools | Spring Boot DevTools, Lombok |

---

## ✨ Features

- 📬 **Contact Form** — Users can submit contact messages with name, email, mobile number, subject, and message
- 🔐 **Authentication** — Spring Security-based login and access control
- 🗃️ **Admin Dashboard** — View and manage contact form submissions by status
- ✅ **Form Validation** — Server-side validation with meaningful error messages
- 💾 **Persistent Storage** — MySQL database with Hibernate auto DDL

---

## 🛠️ Prerequisites

Before running this project, make sure you have:

- Java 17+ (project uses Java 25)
- Maven 3.6+
- MySQL 8.x running locally
- IntelliJ IDEA (recommended) or any Java IDE

---

## ⚙️ Setup & Installation

### 1. Clone the repository

```bash
git clone https://github.com/somuravikiran/School_Application.git
cd School_Application/School_Application
```

### 2. Create the MySQL database

```sql
CREATE DATABASE school;
```

### 3. Configure the database connection

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/school
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

### 4. Build and run

```bash
mvn clean install
mvn spring-boot:run
```

Or run `SchoolApplication.java` directly from your IDE.

### 5. Access the application

Open your browser and navigate to:

```
http://localhost:8080
```

---

## 📁 Project Structure

```
School_Application/
├── src/
│   ├── main/
│   │   ├── java/com/greetlabs/School_Application/
│   │   │   ├── SchoolApplication.java          # Main entry point
│   │   │   ├── controller/
│   │   │   │   ├── ContactController.java
│   │   │   │   └── GlobalExceptionController.java
│   │   │   ├── model/
│   │   │   │   ├── BaseEntity.java
│   │   │   │   └── Contact.java
│   │   │   ├── repository/
│   │   │   │   └── ContactRepository.java
│   │   │   └── service/
│   │   │       └── ContactService.java
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   ├── static/                         # CSS, JS, images
│   │   │   └── templates/                      # Thymeleaf HTML templates
├── pom.xml
└── README.md
```

---

## 🔑 Key Dependencies (pom.xml)

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webmvc</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
</dependency>
```

---

## 🧩 Database Schema

The application uses `ddl-auto=update`, so Hibernate creates/updates tables automatically. The main table is:

**`contact_msg`**

| Column | Type | Description |
|--------|------|-------------|
| contact_id | INT (PK, AUTO) | Primary key |
| name | VARCHAR | Sender's name |
| email | VARCHAR | Sender's email |
| mobile_num | VARCHAR | Sender's mobile number |
| subject | VARCHAR | Message subject |
| message | TEXT | Message body |
| status | VARCHAR | Message status (open/closed) |

---

## 🐛 Common Issues & Fixes

| Error | Fix |
|-------|-----|
| `'url' must start with "jdbc"` | Change `mysql://` to `jdbc:mysql://` in `application.properties` |
| `Failed to load driver class com.mysql.cj.jdbc.Driver` | Add `mysql-connector-j` dependency to `pom.xml` |
| `Not a managed type: class Contact` | Add `@Entity` to `Contact.java` and `@MappedSuperclass` to `BaseEntity.java` |
| `Could not resolve attribute 'status'` | Add `private String status;` field to `Contact.java` |

---

## 👤 Author

**Somu Ravikiran**  
GitHub: [@somuravikiran](https://github.com/somuravikiran)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
