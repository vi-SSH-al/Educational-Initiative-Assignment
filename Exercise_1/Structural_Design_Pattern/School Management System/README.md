# School Management System

## Overview

The **School Management System** is a terminal-based application designed to manage students and teachers in a school environment. It implements the Composite Design Pattern, allowing users to organize and display school members hierarchically. The system enables customer support representatives to resolve customer issues efficiently by utilizing different resolution strategies.

## Features

- Add students and teachers to the school.
- Display the complete structure of the school, including classes and members.
- Exception handling for input validation.
- Logging of actions and errors for monitoring.

## Classes

- **SchoolComponent**: Interface for components (students, teachers, classes) in the school management system.
- **Student**: Represents a student in the school.
- **Teacher**: Represents a teacher in the school.
- **Class**: Composite class that can contain students and teachers.
- **SchoolException**: Custom exception class for error handling in the school management system.
- **SchoolService**: Service class that handles operations for adding and displaying students and teachers.

## Usage Instructions

1. Clone or download the project files.
2. Create a folder named **`SchoolManagementSystem`**.
3. Place all the provided `.java` files inside the **`SchoolManagementSystem`** folder.
4. Create a **`logs`** folder inside **`SchoolManagementSystem`** for logging purposes.
5. Compile and run the `SchoolManagementSystem.java` file.

### Example Usage

- Run the program.
- Follow the on-screen menu to add students and teachers.
- View the structure of the school.
- Exit the application.

## Logging

Logs will be generated in the `logs/application.log` file, capturing all activities and errors.

## Exception Handling

The system implements robust exception handling to ensure invalid inputs are managed gracefully, providing informative feedback to users.

## Requirements

- Java Development Kit (JDK) 8 or higher
- IDE (e.g., IntelliJ IDEA, Eclipse) or command-line interface for compiling and running Java applications

## License

This project is licensed under the MIT License. See the LICENSE file for details.
