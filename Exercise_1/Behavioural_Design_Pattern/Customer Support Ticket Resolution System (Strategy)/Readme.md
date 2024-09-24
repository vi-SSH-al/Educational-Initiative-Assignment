# Customer Support Ticket Resolution System

## Overview

The **Customer Support Ticket Resolution System** is designed to assist customer support representatives in resolving various types of support tickets efficiently. Using the **Strategy Design Pattern**, different resolution strategies are applied based on the type of issue. This allows for flexible and dynamic handling of categories such as **Technical Support**, **Billing Inquiry**, and **General Inquiry**.

## Key Features

- **Dynamic Strategy Selection**: The system dynamically selects and applies the appropriate resolution strategy based on the ticket type.
- **Modular Design**: New ticket types and resolution strategies can be easily added by extending the system.
- **Logging and Error Handling**: Centralized logging and defensive programming are applied for better traceability and error handling.

## Design Pattern Used

This system uses the **Strategy Design Pattern**. It defines a family of algorithms, encapsulates them, and makes them interchangeable. This allows the algorithm (in this case, ticket resolution strategy) to vary independently from the clients that use it.

### Key Components

- **TicketResolutionStrategy**: This is the strategy interface that defines the method for resolving tickets.
- **Concrete Strategies**:
  - **TechnicalSupportResolution**: Implements resolution for technical support tickets.
  - **BillingInquiryResolution**: Implements resolution for billing inquiries.
  - **GeneralInquiryResolution**: Implements resolution for general inquiries.
- **Ticket**: Represents a support ticket with attributes such as `id`, `description`, and `type`.
- **TicketProcessor**: Context class responsible for setting and executing the appropriate ticket resolution strategy.
- **Logger**: Singleton class for centralized logging.

## How It Works

1. **User Input**: The user creates a ticket by providing a description and selecting the type of issue.
2. **Strategy Selection**: The system selects the appropriate strategy based on the ticket type.
3. **Ticket Resolution**: The selected strategy resolves the ticket, and logs are generated throughout the process.
4. **Logging**: Logs track the strategy selection and ticket resolution process.

## Class Descriptions

### TicketResolutionStrategy

- Interface that defines the method `resolveTicket()` which all concrete strategies must implement.

### TechnicalSupportResolution

- Concrete strategy for resolving technical support tickets.
- Implements `resolveTicket()` to define specific steps for technical support.

### BillingInquiryResolution

- Concrete strategy for resolving billing inquiries.
- Implements `resolveTicket()` to define specific steps for billing-related issues.

### GeneralInquiryResolution

- Concrete strategy for resolving general inquiries.
- Implements `resolveTicket()` to define specific steps for general customer questions.

### Ticket

- Represents a customer support ticket.
- Contains attributes: `id`, `description`, and `type`.
- Provides validation for non-null and non-empty values for description and type.

### TicketProcessor

- Context class responsible for executing the resolution strategy.
- Contains methods:
  - `setResolutionStrategy()`: Sets the current strategy for ticket resolution.
  - `resolveTicket()`: Applies the current strategy to resolve the ticket.

### Logger

- Singleton class for logging actions and errors.
- Provides `info()` and `error()` methods for logging.

## Usage Instructions

1. **Compile the Project**:
   You can use a Java IDE (like IntelliJ, Eclipse) or the command line to compile the `.java` files. Ensure that all files are in the same directory.

2. **Run the Application**:
   Run the `Main.java` file to start the application. A terminal-based UI will appear, allowing you to input a ticket description and select the type of issue.

3. **Select Ticket Type**:
   After inputting the ticket description, choose the type of issue:

   - `1` for Technical Support
   - `2` for Billing Inquiry
   - `3` for General Inquiry

4. **Ticket Resolution**:
   The system will automatically apply the corresponding strategy based on the ticket type and resolve the issue. Logs will be printed to the console for each step.

## Example Output

Enter the ticket description: Internet connection not working. Choose the type of issue:

1. Technical Support
2. Billing Inquiry
3. General Inquiry Enter your choice: 1
