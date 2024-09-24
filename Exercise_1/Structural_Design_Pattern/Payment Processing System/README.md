# Payment Processing System

## Overview

The **Payment Processing System** uses the Adapter Design Pattern to unify various payment methods into a single interface. This allows businesses to process payments seamlessly, regardless of the payment method chosen by the customer.

## Classes

### 1. PaymentMethod

- **Purpose**: Interface for different payment methods.
- **Methods**:
  - `pay(double amount)`: Method to process payment.

### 2. CreditCardPayment

- **Purpose**: Processes credit card payments.
- **Methods**:
  - Implements `pay(double amount)` to handle credit card transactions.

### 3. PayPalPayment

- **Purpose**: Processes PayPal payments.
- **Methods**:
  - Implements `pay(double amount)` to handle PayPal transactions.

### 4. CryptoPayment

- **Purpose**: Processes cryptocurrency payments.
- **Methods**:
  - Implements `pay(double amount)` to handle cryptocurrency transactions.

### 5. PaymentAdapter

- **Purpose**: Adapts various payment methods to a unified interface.
- **Methods**:
  - `PaymentAdapter(String paymentType)`: Constructor to select the appropriate payment method.
  - `pay(double amount)`: Calls the payment method's implementation.

### 6. PaymentProcessor

- **Purpose**: Entry point for the application; interacts with the user.
- **Functionality**: Allows users to choose a payment method and amount, and processes the payment accordingly.

## Usage

1. Run the `PaymentProcessor` class to start the application.
2. Follow the prompts to enter the payment method and amount.
3. Enter "exit" to terminate the application.

## Requirements

- Java Development Kit (JDK)

## License

This project is licensed under the MIT License.
