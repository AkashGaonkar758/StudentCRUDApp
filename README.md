# Student CRUD Application

This repository contains a full-stack student management application. It uses **Spring Boot** (Java) for the backend, **React** (JavaScript) for the frontend, and **MySQL** for the database, enabling operations like adding, updating, deleting, and retrieving student records.

## Table of Contents

- [Overview](#overview)
- [Installation](#installation)
- [Usage](#usage)
- [Database Setup](#database-setup)
- [Technologies Used](#technologies-used)
- [Model-View-Controller (MVC) Architecture](#mvc-architecture)
- [Object-Relational Mapping](#object-relational-mapping)

## Overview

This project includes a Spring Boot backend and a React frontend for managing student data. The backend exposes a REST API to perform CRUD operations, while the frontend interacts with the backend and displays the data.

## Installation

### Set up the Backend

1. Navigate to the `StudentCRUDApp` directory and run the Spring Boot backend with Maven:
   ```bash
   mvn spring-boot:run
   ```

### Set up the Database

1. Open **MySQL Workbench** and create a database named `studentdb` (or change the database name in the `application.properties` file).
2. The required table will be created automatically on the first run of the backend. If the table already exists, no new table will be created.

### Set up the Frontend

1. Navigate to the `frontend` directory:
   ```bash
   cd frontend
   ```

2. Install the dependencies:
   ```bash
   npm install
   ```

3. Run the development server:
   ```bash
   npm run dev
   ```

   The frontend will be available at [http://localhost:5173](http://localhost:5173).

## Usage

1. After starting both the backend and frontend servers, navigate to the frontend in your browser (`http://localhost:5173`).
2. You can now perform the following actions:
   - **Add a Student**: Enter the name and grade of a student and click "Add".
   - **Update a Student**: Select a student from the list, change their details, and click "Update".
   - **Delete a Student**: Select a student from the list and click "Delete".
   - **Find a Student**: Enter the unique student ID to find a student.

## Database Setup

The application uses **MySQL** as the database. The following SQL statement will create the required table for student records:

```sql
CREATE TABLE IF NOT EXISTS student(
    id INT AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(30) NOT NULL,
    grade INT NOT NULL
);
```

This table is automatically created when the backend starts, if it doesn't already exist. The backend, through the Spring Boot application, executes a SQL statement during the application’s startup (`@PostConstruct` annotation), ensuring the table is created in the `studentdb` database if it's not already present.

## Model-View-Controller (MVC) Architecture

The application follows the **Model-View-Controller (MVC)** design pattern for separation of concerns.

- **Model**: Represents the data and the business logic. In this case, the `Student` class represents the student model, and all the CRUD operations are managed via the `Repo` class.
- **View**: The frontend, built using React, serves as the view that communicates with the user.
- **Controller**: The `StudentController` in Spring Boot acts as the intermediary between the model and the view, handling HTTP requests and interacting with the repository layer.

This structure allows for better maintainability and scalability of the application.

## Object-Relational Mapping (ORM)

This application uses **manual object-relational mapping (ORM)**. The mapping between the Java objects and the relational database is done manually. Here’s how the data is mapped:

- **Student Model**: Represents the `student` table in MySQL. It contains fields like `id`, `name`, and `grade`.
- **Repository**: The `Repo` class manually maps Java objects to SQL queries. For example, `jdbcTemplate.update()` is used for adding, updating, or deleting a student in the database.
- **RowMapper**: The `StudentRowMapper` is used to convert rows of the result set into `Student` objects, which are then returned by the repository methods.

This approach allows greater flexibility and control over how the database is queried and how Java objects are stored and retrieved.

## Technologies Used

- **Backend**: Spring Boot, Java, SQL (MySQL)
- **Frontend**: React, JavaScript, HTML, CSS
- **Database**: MySQL

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
