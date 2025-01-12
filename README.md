# Student CRUD Application

This project is a Full-Stack application that allows users to add, update, delete, and find student records in a MySQL database. It uses Java with Spring Boot for the backend, and React for the frontend.

## Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Database Setup](#database-setup)
- [Frontend](#frontend)
- [Backend](#backend)
- [Contributing](#contributing)

## Overview

This application enables managing student data with the following operations:

- **Add Student**: Allows you to add new student records.
- **Update Student**: Allows you to update student details like name and grade.
- **Delete Student**: Enables removal of student records.
- **Find Student**: Allows searching for students based on their unique ID.

The backend is built using **Spring Boot**, **MVC** model, and **MySQL** for database management. On the frontend, **React** and **JavaScript** are used to create the user interface.

## Tech Stack

- **Backend**: 
  - Spring Boot (Java)
  - Spring MVC
  - MySQL (Database)
  - JDBC Template (For data access)
  
- **Frontend**:
  - React (JavaScript)
  - Vite (For development server)

## Getting Started

### Prerequisites

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (version 8 or higher)
- [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)
- [Node.js and npm](https://nodejs.org/) (for frontend)

## Installation

### Set up the Backend

1. Navigate to the `StudentCRUDApp` directory and run the Spring Boot backend with Maven:
   ```bash
   mvn spring-boot:run
   ```

### Set up the Database

1. Open **MySQL Workbench** and create a database named `studentdb` (or change the database name in the `application.properties` file).
2. The required table will be created automatically on the first run of the backend.

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

### Part 2: Usage, Database Setup, Frontend, Backend
```markdown
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
