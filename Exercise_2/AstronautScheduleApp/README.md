# Astronaut Schedule Manager

## Overview

The Astronaut Schedule Manager is a console-based application that helps astronauts organize their daily tasks. It allows users to add, remove, and view tasks while ensuring there are no conflicts in scheduling.

## Features

- Add new tasks with description, start time, end time, and priority level.
- Remove existing tasks.
- View all tasks sorted by start time.
- Validate that new tasks do not overlap with existing tasks.
- Edit existing tasks and mark them as completed.
- View tasks based on a specific priority level.
- Graceful error handling for invalid operations.
- logging the application

## Class Descriptions

1. **AstronautScheduleManager**: The main class to start the console application and interact with users for managing tasks.
2. **ScheduleManager**: A singleton class responsible for managing the task list and ensuring only one instance exists throughout the application.
3. **Task**: Represents a task with a description, start time, end time, and priority level.
4. **TaskFactory**: A factory class that creates `Task` objects while validating input parameters.
5. **TaskPriority**: An enumeration for defining different priority levels for tasks (e.g., High, Medium, Low).
6. **TaskConflictObserver**: An interface for the observer pattern to notify users about task conflicts.
7. **TaskConflictNotifier**: A concrete observer that listens for task conflicts and alerts the user when a new task overlaps with existing ones.
8. **ScheduleException**: A custom exception class for handling general scheduling errors.
9. **TaskNotFoundException**: A custom exception class for handling scenarios where a task is not found during removal or editing.
10. **InvalidTimeFormatException**: A custom exception class for handling invalid time format inputs.

## Design Patterns Used

1. **Singleton Pattern**: The `ScheduleManager` class ensures that there is only one instance managing the tasks.
2. **Factory Pattern**: The `TaskFactory` class is used to create `Task` objects with validation.
3. **Observer Pattern**: Users are notified if a new task conflicts with an existing one, enhancing interactivity.

## Running the Application

### Compile the Application

Run the following command to compile all files:

```bash
javac *.java
```

### Start the Application

Run the following command to start the application:

```bash
java AstronautScheduleManager
```

### Interacting with the Application

Follow the prompts in the console to manage your tasks. Input the commands as specified by the prompts.

## Example Inputs and Outputs

### Positive Cases

- **Input**: Add Task("Morning Exercise", "07:00", "08:00", "High")

  - **Output**: Task added successfully. No conflicts.

- **Input**: View Tasks
  - **Output**:
    07:00 - 08:00: Morning Exercise [High]

### Negative Cases

- **Input**: Add Task("Training Session", "09:30", "10:30", "High")

  - **Output**: Error: Task conflicts with existing task "Team Meeting".

- **Input**: Add Task("Invalid Time Task", "25:00", "26:00", "Low")
  - **Output**: Error: Invalid time format.

## Conclusion

The Astronaut Schedule Manager demonstrates best practices in Java development, including design patterns, error handling, and logging. It is designed to be user-friendly while maintaining a robust backend to handle scheduling efficiently.
