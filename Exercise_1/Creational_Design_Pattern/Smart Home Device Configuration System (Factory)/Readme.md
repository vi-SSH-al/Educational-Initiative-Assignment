# Smart Home Device Configuration System

## Overview

The **Smart Home Device Configuration System** demonstrates the use of the **Factory Design Pattern** to dynamically create and configure various types of smart devices. This system allows customer support representatives to efficiently configure smart home devices (e.g., Smart Light, Smart Thermostat, Smart Security Camera) based on user input, improving user experience and operational efficiency.

## Use Case

Smart home ecosystems consist of various devices requiring different configurations. The Factory Design Pattern enables the system to create device objects without exposing the client to the instantiation logic, allowing for easy extension and maintenance.

## Key Requirements

- Utilize the Factory Design Pattern for device instantiation.
- Implement specific configuration processes for each device type.
- Provide logging and error handling mechanisms to ensure smooth operation.
- Support easy extension for new device types.

## Class Descriptions

### SmartDevice (Interface)

Common interface for all smart devices. Each smart device must implement the `configure()` method.

### SmartLight (Class)

Implements `SmartDevice` and provides the configuration logic for a smart light, including brightness and color adjustments.

### SmartThermostat (Class)

Implements `SmartDevice` and defines the configuration logic for a smart thermostat, allowing users to set temperature and schedules.

### SmartSecurityCamera (Class)

Implements `SmartDevice` and includes the configuration steps for a smart security camera, such as motion detection sensitivity and camera angles.

### DeviceFactory (Class)

Factory class responsible for creating instances of smart devices based on the requested type. Implements the logic to instantiate and return the appropriate device.

### Logger (Class)

Singleton class for centralized logging of application actions and errors. Provides methods for logging informational and error messages.

### Main (Class)

Entry point for the application. It interacts with the user, retrieves the desired device type, utilizes the factory to create the device, and calls the configuration method.

## How to Run the Project

1. **Compile the Project**:
   Ensure all `.java` files are in the same folder. Use a Java IDE or command line to compile the project.

2. **Run the Application**:
   Execute the `Main.java` class to start the application.

3. **Device Type Input**:
   Enter the type of smart device you want to configure: `Light`, `Thermostat`, or `Camera`.

4. **Configuration Process**:
   The system will execute the appropriate configuration steps for the selected device type.
