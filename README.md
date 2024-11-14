# Simple Social Media Application

A RESTful API for a simple social media application built with Spring Boot, Hibernate, and PostgreSQL. The application allows users to create and view posts, follow other users, and like posts. Each post includes a title, body, and author. Hibernate is used to persist the post and user data in the database.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Database Setup](#database-setup)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [API Endpoints](#api-endpoints)
- [Project Structure](#project-structure)
- [Additional Notes](#additional-notes)

## Features

- User registration and authentication
- Create, read, update, and delete posts
- Follow/unfollow other users
- Like/unlike posts
- View posts from followed users
- Unit tests with coverage > 80%

## Prerequisites

- **Java Development Kit (JDK) 11 or higher**
- **Gradle** (optional, as the wrapper is included)
- **PostgreSQL** database
- **Git** (optional, for cloning the repository)

## Installation

1. **Clone the repository (if applicable):**

   ```bash
   git clone https://github.com/StarFleet1334/social-media-app-Task-.git
   cd social-media-app


Set up the PostgreSQL database:

Ensure PostgreSQL is installed and running.

Create a database named socialmedia (or your preferred name).

sql
Copy code
CREATE DATABASE socialmedia;
Configure database credentials:

Update the application.properties file with your PostgreSQL username and password.

properties
Copy code
spring.datasource.url=jdbc:postgresql://localhost:5432/socialmedia
spring.datasource.username=your_postgres_username
spring.datasource.password=your_postgres_password
Database Setup
Option 1: Let Hibernate Create Tables Automatically
By default, Hibernate is configured to create the necessary tables automatically.

Ensure the following property is set in application.properties:

properties
Copy code
spring.jpa.hibernate.ddl-auto=update
Option 2: Manually Create Tables
If you prefer to manually create the tables, use the provided SQL scripts.

Create app_user Table:

sql
Copy code
CREATE TABLE app_user (
id BIGSERIAL PRIMARY KEY,
username VARCHAR(255),
password VARCHAR(255)
);
Create posts Table:

sql
Copy code
CREATE TABLE posts (
id BIGSERIAL PRIMARY KEY,
title VARCHAR(255),
body TEXT,
author_id BIGINT NOT NULL,
CONSTRAINT fk_author
FOREIGN KEY (author_id)
REFERENCES app_user(id)
ON DELETE CASCADE
);
Update application.properties to prevent Hibernate from modifying the schema:

properties
Copy code
spring.jpa.hibernate.ddl-auto=validate
Configuration
Ensure the following configurations are set in application.properties:

properties
Copy code
# Database configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/socialmedia
spring.datasource.username=your_postgres_username
spring.datasource.password=your_postgres_password

# Hibernate configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL95Dialect

# Show SQL statements (optional)
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Logging level (optional)
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
Note: Adjust the dialect in spring.jpa.database-platform based on your PostgreSQL version.

Running the Application
You can run the application using the Gradle wrapper included in the project.

Using Gradle Wrapper
bash
Copy code
./gradlew bootRun
Using Gradle Installed Locally
bash
Copy code
gradle bootRun
Running as a Jar File
Build the application:

bash
Copy code
./gradlew build
Run the jar file:

bash
Copy code
java -jar build/libs/social-media-app-0.0.1-SNAPSHOT.jar
Expected Console Output
Upon running, you should see output indicating that a user and a post have been created:

yaml
Copy code
Created User: john_doe
Created Post: Hello World by john_doe
Testing
Running Unit Tests
The project includes unit tests with coverage greater than 80%.

To run the tests, execute:

bash
Copy code
./gradlew test






