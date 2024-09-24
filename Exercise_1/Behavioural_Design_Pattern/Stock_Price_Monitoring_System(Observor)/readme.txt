Overview
This project demonstrates the Observer Design Pattern in a stock price notification system where multiple clients (observers) can subscribe or unsubscribe to receive stock price updates from a stock price tracker (subject). The user can dynamically interact with the system via a terminal-based interface, registering clients, adjusting update intervals, and viewing the current stock prices.

Design Pattern: Observer
Observer Pattern defines a one-to-many dependency between objects. When one object (subject) changes its state, all its dependent objects (observers) are notified and updated automatically.
Use Case: Stock Price Notification System
This system simulates stock price updates for a specific stock symbol (e.g., "AAPL"). Multiple clients (observers) can register to receive these updates in real-time. The stock prices are simulated using random values, and the user can control the update interval. This use case represents a typical real-time notification system like stock or news feeds.

Key Classes and Responsibilities:
StockObserver (Interface):

Defines the updatePrice method that all observers must implement to receive stock price updates.
StockPriceTracker (Subject):

Manages the stock price and notifies all registered observers of any updates.
Contains methods to register/unregister observers and update the stock price.
Client (Observer):

Implements StockObserver and receives notifications of stock price changes.
Acts as a user/client who gets informed when the stock price changes.
StockPriceSimulator (Simulation of Price Changes):

Simulates the stock price changes using a random value generator and updates the stock tracker periodically.
Main (Driver Class):

Provides an interactive menu where users can register/unregister clients, view the current stock price, and control the update interval.
Logger (Utility Class):

Implements a simple logging mechanism to track information, warnings, and errors.
InvalidStockSymbolException (Custom Exception):

Handles validation errors for stock symbols, ensuring they are not null or empty.
Setup & Running:
Compile all the files in the same folder.
Run Main.java to start the terminal-based interaction.
Interact with the menu to register clients, set update intervals, and view stock prices.