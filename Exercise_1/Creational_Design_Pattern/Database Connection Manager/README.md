# Database Connection Manager

## Overview

The **Database Connection Manager** provides a centralized way to manage database connections using the Singleton Design Pattern. It ensures that only one instance of the connection manager exists throughout the application.

## Classes

### 1. DatabaseConnectionManager

- **Purpose**: Manages the single instance of the database connection.
- **Methods**:
  - `getInstance()`: Returns the singleton instance.
  - `getConnection()`: Returns the current database connection.
  - `closeConnection()`: Closes the database connection.

### 2. DatabaseConfig

- **Purpose**: Holds database configuration settings.
- **Methods**:
  - `getInstance()`: Returns the singleton instance.
  - `getUrl()`, `getUsername()`, `getPassword()`: Returns the database connection settings.

### 3. Logger

- **Purpose**: Provides centralized logging functionality.
- **Methods**:
  - `getInstance()`: Returns the singleton instance.
  - `logInfo()`: Logs an informational message.
  - `logError()`: Logs an error message.

### 4. DatabaseException

- **Purpose**: Custom exception class for handling database-related errors.
- **Constructors**:
  - `DatabaseException(String message)`: Initializes with an error message.
  - `DatabaseException(String message, Throwable cause)`: Initializes with an error message and a cause.

### 5. Main

- **Purpose**: Entry point for the application; interacts with the user.
- **Functionality**: Allows users to execute SQL queries against the database.

## Usage

1. Run the `Main` class to start the application.
2. Follow the prompts to execute SQL queries or exit the application.

## Requirements

- Java Development Kit (JDK)
- MySQL Connector/J library for JDBC

## License

This project is licensed under the MIT License.
